package leetcode.other;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by qifu on 17/3/21.
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();       //use stack to keep index;
        for(int i = 0; i < 2 * len; i++) {
            int cur = nums[i % len];
            while(!stack.isEmpty() && nums[stack.peek()] < cur) {
                res[stack.pop()] = cur;
            }
            if(i < len) {
                stack.push(i);
            }
        }
        return res;
    }
}
