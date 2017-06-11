package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/6/11.
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while(left != right) {
                if(nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }

            }
        }
        return count;
    }
}
