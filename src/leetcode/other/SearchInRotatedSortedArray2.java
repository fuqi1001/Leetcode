package leetcode.other;

/**
 * Created by qifu on 16/3/29.
 原题链接: http://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 在search in rotated sorted array
 原题链接: http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 中我们是依靠中间与边缘元素的大小关系来判断哪一半不收rotate影响任然是优秀的.
 此题中有重复出现,如果遇到中间与边缘元素大小相同,我们就丢失了那边的信息
 因为哪边都有可能是优秀的结果.
 例如原数组为{1,2,3,3,3,3,3},那么旋转之后有可能是{3,3,3,3,1,2},或者{3,1,2,3,3,3,3}
 这样我们判断左边缘与中心都是3,如果我们要寻找1或者2,我们并不知道应该跳向哪一边.
 解决这个的办法只有对边缘移动一步,知道边缘与中间不再相等或者相遇,这导致了会有不能切去一半的可能.
 所以最坏的情况是(比如全部都是一个元素,或者只有一个元素不同于其他元素,而他在最后一个)
 就会出现每次移动一步的情况总共n步
 O(n);
 */
public class SearchInRotatedSortedArray2 {
    //version 1: iterative -> compare nums[left] and nums[mid] to narrow the range

    public boolean search(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = high+low>>>1;
            if(nums[mid] == target) return true;
            if(nums[low] < nums[mid]){
                if(nums[low] <= target && target < nums[mid]) high = mid -1;
                else low = mid + 1;
            }
            else if(nums[low] > nums[mid]){
                if(target >= nums[low] || target < nums[mid]) high = mid -1;
                else low=mid+1;
            }
            else{
                low++;
            }
        }
        return false;
    }

    // version 2: recursive -> compare nums[mid] with nums[left] and nums[right] separtely
    public boolean search(int[] nums,int target){
        return search(nums,target,0,nums.length-1);
    }
    public boolean search(int[] nums,int target,int low,int high) {
        if (low > high) return false;
        int mid = low + high >>> 1;
        if (nums[mid] == target) return true;
        if (nums[low] == nums[mid] && nums[mid] == nums[high])
            return search(nums, target, low + 1, mid - 1) || search(nums, target, mid + 1, high - 1);
        if (nums[low] == nums[mid])
            return search(nums, target, mid + 1, high);
        if (nums[mid] == nums[high])
            return search(nums, target, low, mid - 1);
        if (nums[mid] <= nums[high]) {
            if (nums[mid] < target && target <= nums[high])
                return search(nums, target, mid + 1, high);
            else
                return search(nums, target, low, mid - 1);
        } else {
            if (nums[low] <= target && target < nums[mid])
                return search(nums, target, low, mid - 1);
            else
                return search(nums, target, mid + 1, high);
        }
    }

       // version 3: same as version 1
        public boolean search(int[] A, int target){
            if(A == null || A.length == 0){
                return false;
            }
            int low = 0;
            int high = A.length - 1;
            while(low <= high){
                int mid = (low + high) / 2;
                if(A[mid] == target) return true;
                if(A[mid] > A[low]){
                    if(A[mid] > target && A[low] <= target ){
                        high = mid - 1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                else if( A[mid] < A[low]){
                    if(A[mid] < target && A[high] >= target){
                        low = mid + 1;
                    }
                    else{
                        high = mid - 1;
                    }
                }
                else{
                    low++;
                }
            }
        return false;
        }

}

