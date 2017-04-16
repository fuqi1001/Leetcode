package leetcode.other;

/**
 * Created by qifu on 17/4/15.
 */
public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return nums[0]+"";
        if(nums.length == 2) {
            String res= nums[0] +"/"+nums[1];
            return res;
        }
        String res = nums[0] +"/";
        String temp = nums[1]+"";
        for(int i = 2; i < nums.length; i++) {
            temp+= "/"+nums[i];
        }
        res = res + "(" +temp+ ")";
        return res;
    }

    /*
    a/b/c/d/e
    因为连除 所以从c d e 开始等等后面的数都会变成分子
    所以只需要保证b/[xxxxx]最小就行了
    所以只需要一个括号

     */
}
