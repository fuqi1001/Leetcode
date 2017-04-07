package leetcode.other;

/**
 * Created by qifu on 16/10/25.
 */
public class FindPeakElement {
    /*
    找数组中最大的一个数,必然符合条件
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if((mid > 0) && nums[mid] > nums[mid + 1] && nums[mid ] > nums[mid - 1])
            {
                return mid;
            }
            else if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
