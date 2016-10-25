package leetcode;

/**
 * Created by qifu on 16/10/25.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) start = mid + 1;
            else {
                end = mid;
            }
        }
        return end;
    }


    public int findPeakElement(int[] nums){
        if(nums.length == 0 || nums == null) return 0;
        int start = 0;
        int end = nums.length -1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] < nums[mid - 1]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(nums[start] > nums[end]){
            return start;
        }else{
            return end;
        }
    }
}
