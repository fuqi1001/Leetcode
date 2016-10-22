package leetcode.Implenment;

import java.util.Random;

/**
 * Created by qifu on 16/10/22.
 */
public class RandomPickIndex {
    int[] nums;
    Random rdm;
    public Solution(int[] nums) {
        this.nums = nums;
        rdm = new Random();
    }
    public int pick(int target) {
        int cnt = 0;
        int res = -1;
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] == target) {
                cnt++;
                res = rdm.nextInt(cnt) == 0? i :res;
            }
        }
        return res;
    }
}
