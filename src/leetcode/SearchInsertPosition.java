package leetcode;

/**
 * Created by qifu on 16/10/18.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0 ; i <= nums.length ;i++){
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }

    //binary search

    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return left;
    }

    public int searchInsert(int[] nums, int target){
        if ( nums == null || nums.length == 0){
            return 0;
        }
        int start = 0 ,end = nums.length - 1;
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }

        if(nums[start] >= target){
            return start;
        }else if(nums[end] >= target){
            return end;
        }
        else{
            return end + 1;
        }
    }
}
