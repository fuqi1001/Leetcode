package leetcode.other;

/**
 * Created by qifu on 16/3/29.
 原题链接: http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 因为rotate,当我们切去一半的时候可能会出现误区
 假设数组nums,每次左边缘是Low,右边缘是high,中间是Mid
 1. target == nums[mid] return true;
 2. nums[mid] < nums[high] 说明mid 到 high 有序,只需要判断target在不在mid到high之间,如果是则把
 左边缘移动到mid+1,如果不是,target在另一半,即high 移动到Mid-1
 3. nums[mid] >= nums[high] 说明low 到 mid 有序,同样只需要判断target是否在这个范围内,相应移动边缘


 每次可以切掉一半数据,时间复杂度O(logn) 空间O(1)


 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;

            if(nums[mid] < nums[right]) {
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    ///
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0 ;
        int right = len - 1;

        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;

            if(nums[mid] >= nums[left]) {
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        if(nums[left] == target) return left;
        else if(nums[right] == target) return right;
        else return -1;
    }
}
