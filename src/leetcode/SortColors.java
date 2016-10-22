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
}
