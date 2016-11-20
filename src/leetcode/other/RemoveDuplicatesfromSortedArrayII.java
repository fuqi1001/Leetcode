package leetcode.other;

/**
 * Created by qifu on 16/10/25.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int index = 1;
        int count = 1;
        for(int i = 1; i < nums.length ;i++){
            if(nums[i] != nums[i - 1]){
                nums[index] = nums[i];
                count = 1;
                index++;
            }
            else if(nums[i] == nums[i - 1] && count < 2){
                nums[index] = nums[i];
                count++;
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int index = 0;
        int i , j ;
        for(i = 0 ; i < nums.length;){
            int cur = nums[i];
            for(j = i ;  j < nums.length ;j++){
                if(nums[j] != cur) break;
                if(j - i < 2) nums[index++] = nums[i];
            }
            i = j;
        }
        return index;
    }
}
