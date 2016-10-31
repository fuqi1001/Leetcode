package leetcode;

import java.util.Arrays;

/**
 * Created by qifu on 16/10/31.
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};

        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        Arrays.fill(res,-1);

        int mid = 0;

        //find left
        while(left + 1< right){
            mid = (left+right) / 2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid ;
            }else {
                right = mid;
            }
        }
        if(nums[left] == target){
            res[0] = left;
        }else if(nums[right] == target) {
            res[0] = right;
        }else{
            return res;
        }

        //find right

        left = 0 ;
        right = nums.length - 1;

        while(left + 1 < right){
            mid = (left+right) / 2;
            if(nums[mid] == target){
                left = mid;
            }else if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[right] == target){
            res[1] = right;
        }else if(nums[left] == target){
            res[1] = left;
        }else{
            return res;
        }
        return res;
    }


    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return new int[]{-1,-1};

        int left = 0;
        int right = nums.length - 1;
        int mid = (left+right) / 2;
        while(left < right){
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;

            else{
                left = mid;
                right = mid;
                while(left - 1 >=0 && nums[left - 1] == target) left--;
                while(right +1 <= nums.length - 1&& nums[right + 1] == target) right++;
                break;
            }
            mid = (left+right) / 2;
        }
        if(nums[left] != target || nums[right] != target ) return new int[]{-1,-1};
        else return new int[]{left,right};
    }
}
