package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/9/8.
 */
public class HouseRobber {
    public int rob(int[] nums){
        int max = 0;
        int pre = 0;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            int temp = max;
            max = Math.max(max,pre + nums[i]);
            pre = temp;
        }
        return max;
    }

    public int rob(int[] num) {
        if (num==null || num.length==0) return 0;
        int maxToPos[] = new int[num.length+1]; //the maximum amount to the i'th house
        maxToPos[0] = 0;
        maxToPos[1] = num[0];
        for (int i=2; i<maxToPos.length; i++){
            maxToPos[i] = Math.max(maxToPos[i-1],maxToPos[i-2]+num[i-1]);
        }
        return maxToPos[maxToPos.length-1];
    }
}
