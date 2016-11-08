package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/11/8.
 */
public class JumpGame {

    //On2 TL
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + nums[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }

        return can[nums.length - 1];
    }

    //greedy

    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null) return false;

        int point = nums[0];
        for(int i = 0 ; i < nums.length ;i++){
            if(i <= point && nums[i] + i >= point){
                point = nums[i] + i;
            }
        }
        return point >= nums.length - 1;
    }
}
