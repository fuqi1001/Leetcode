package leetcode;

/**
 * Created by qifu on 16/9/5.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while ( i < j){
            if(numbers[i] + numbers[j] == target) break;
            else if (numbers[i]+numbers[j] < target) i++;
            else j--;
        }
        if( i >= j) return new int[]{-1,-1};
        return new int[]{i+1,j+1};
    }

    public int[] twoSum(int[] numbers, int target){
        int validMin = target - numbers[numbers.length - 1];
        int validMax = target - numbers[0];

        int validRight = numbers.length - 1;
        int validLeft = 0;

        while(numbers[validRight] > validMax) validRight--;
        while(numbers[validLeft] < validMin) validLeft++;

        int left = validLeft;
        int right = validRight;

        while (left < right){
            while(numbers[right] > target - numbers[left]) right--;
            if(numbers[right] + numbers[left] == target) return new int[]{left+1,right+1};
            while(numbers[left] < target - numbers[right]) left++;
            if(numbers[right] + numbers[left] == target) return new int[]{left+1,right+1};

        }
        return null;
    }
}
