package leetcode.other;

/**
 * Created by qifu on 17/3/15.
 */
public class RangeSumQuery {
    int[] arr;
    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        arr = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0) return arr[j];
        else {
            return arr[j] - arr[i - 1];
        }
    }
}
