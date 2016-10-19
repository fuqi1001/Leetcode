package leetcode;

/**
 * Created by qifu on 16/10/18.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)return -1;
        int left = 0;
        int right = nums.length - 1;
        int target = nums[right];

        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(nums[left] < target){
            return nums[left];
        }else{
            return nums[right];
        }
    }

    public int findMin(int[] nums){
        int start = 0 ;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return nums[start];
    }
}
