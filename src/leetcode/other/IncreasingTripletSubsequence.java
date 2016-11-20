package leetcode.other;

/**
 * Created by qifu on 16/10/20.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int min = Integer.MAX_VALUE;
        int min_2 = Integer.MAX_VALUE;

        for(int num : nums){
            if(num <= min) min = num;
            else if(num < min_2) min_2 = num;
            else if(num > min_2) return true;
        }
        return false;
    }
}
