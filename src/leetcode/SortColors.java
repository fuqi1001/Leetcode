package leetcode;

/**
 * Created by qifu on 16/10/22.
 */
public class SortColors {

    //counting sort
    public void sortColors(int[] nums) {
        int[] count =new int[3];
        for(int i = 0 ; i < nums.length ;i++){
            count[nums[i]]++;
        }
        for(int i = 0 ; i < nums.length ;i++){
            if(i < count[0]) nums[i] = 0;
            else if(i>= count[0] && i < count[1] + count[0]) nums[i] = 1;
            else nums[i] = 2;
        }

    }
    //
    public void sortColors(int[] nums){
        if(nums.length == 1) return;
        int left = 0 ;
        int right = nums.length - 1;
        int i = 0 ;
        int count = 0;
        while(i <= right ){
            if(nums[i] == 0){
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] =temp;
                left++;
                i++;
            }

            else if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 2){
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            }
        }

    }
}
