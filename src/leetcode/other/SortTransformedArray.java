package leetcode.other;

/**
 * Created by qifu on 17/3/23.
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int[] res = new int[len];
        int index = a >= 0 ? len - 1 : 0;
        int left = 0;
        int right = len - 1;
        while(left <= right) {
            if(a >= 0) {
                res[index--] = count(nums[left], a,b,c) > count(nums[right],a,b,c) ? count(nums[left++], a,b,c) : count(nums[right--],a,b,c);
            } else {
                res[index++] = count(nums[left], a,b,c) < count(nums[right],a,b,c) ? count(nums[left++], a,b,c) : count(nums[right--],a,b,c);
            }
        }
        return res;
    }
    private int count(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    /*
    如果a 大于等于0  数组两头 > 数组中间
    如果a 小于0  数组中间 > 数组两头
     */
}
