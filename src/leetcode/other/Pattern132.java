package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 16/11/21.
 */
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0 ; i--){
            if(nums[i] < third) return true;
            else{
                while(!stack.isEmpty() && nums[i] > stack.peek()){
                    third = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
