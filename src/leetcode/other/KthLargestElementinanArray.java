package leetcode.other;

/**
 * Created by qifu on 16/10/22.
 */
public class KthLargestElementinanArray {

    //quick select
    public int findKthLargest(int[] nums, int k) {
        if(k < 1 || nums == null) return 0;
        return helpFindK(nums.length - (k - 1), nums, 0, nums.length - 1);
    }

    private int helpFindK(int k, int[] nums, int start, int end) {
        int pivot = nums[end], left = start, right = end;
        while(true) {
            while(nums[left] < pivot && left < right) left++;
            while(nums[right] >= pivot && left < right) right--;
            if(left == right) break;
            swap(nums, left, right);
        }
        swap(nums,left, end);
        if(k == left + 1) {
            return pivot;
        } else if(k < left + 1) {
            return helpFindK(k, nums, start, left - 1);
        } else {
            return helpFindK(k, nums, left + 1, end);
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    ////counting sort

    public int findKthLargest(int[] nums, int k){
        int max = nums[0];
        int min = nums[0];

        for(int i = 1; i < nums.length;i++){
            if(nums[i] > max) max = nums[i];
            else if(nums[i] < min) min = nums[i];
        }

        int[] count = new int[max - min + 1];

        for(int i = 0 ; i < nums.length ;i++){
            count[nums[i] - min]++;
        }
        int large = 0;
        for(int i = count.length - 1; i>=0 ;i--){
            k -= count[i];
            if(k <= 0){
                large = i + min;
                break;
            }
        }
        return large;
    }
}
