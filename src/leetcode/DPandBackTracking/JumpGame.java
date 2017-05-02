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

    //邪道?
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;

        for(int curr = nums.length-2; curr>=0;curr--){
            if(nums[curr] == 0){
                int neededJumps = 1;
                while(neededJumps > nums[curr]){
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }

    /*
    跳0.
    从后往前扫
    如果碰到0, 则用NeededJumps来寻找当前点之前的符合条件的点来跳过这个0
    若果一直找不到nums[curr] > needeJumps则说明跳不过这个0  则不存在解

     */
}
