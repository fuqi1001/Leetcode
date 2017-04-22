package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/21.
 */
public class twoSumSorted {
    //two sum : 数组排好升序 二分寻找
    //未优化,直接二分
    public int[] twoSum_(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            if(numbers[left] + numbers[right] > target) right--;
            else if(numbers[left] + numbers[right] < target) left++;
            else break;
        }
        return new int[]{left + 1, right + 1};
    }


    //优化,先把不合适的排除
    public int[] twoSum_2(int[] numbers, int target) {
        int min_value = target - numbers[numbers.length - 1];   //需要的最小值
        int max_value = target - numbers[0];        //需要的最大值

        int left_most = 0;
        int right_most = numbers.length - 1;

        while(numbers[left_most] < min_value) left_most++;
        while(numbers[right_most] > max_value) right_most--;

        int left = left_most;
        int right = right_most;

        while(left < right) {
            while(numbers[left] + numbers[right] > target) right--;
            while(numbers[left] + numbers[right] < target) left++;
            if(numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
        }
        return null;
    }
}
