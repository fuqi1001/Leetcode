package leetcode.other;

/**
 * Created by qifu on 16/11/15.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = nums.length - 2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = i + 1;
            while(j < nums.length && nums[j] > nums[i]){
                j++;
            }
            j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        rev(nums, i+1);
    }
    public void rev(int[] nums, int left){
        int right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    //http://blog.csdn.net/linhuanmars/article/details/20434115
}
