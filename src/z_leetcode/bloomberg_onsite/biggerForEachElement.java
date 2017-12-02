package z_leetcode.bloomberg_onsite;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class biggerForEachElement {
    public List<int[]> check(int[] nums) {
        if(nums.length < 2) return new ArrayList<>();

        List<int[]> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }

            if(stack.peek() > nums[i]) {
                res.add(new int[]{nums[i], stack.peek()});
                stack.push(nums[i]);
            } else {
                while(stack.peek() < nums[i]) {
                    stack.pop();
                    if(stack.isEmpty()) break;
                }
                if(!stack.isEmpty()) {
                    res.add(new int[] {nums[i], stack.peek()});
                }
                stack.push(nums[i]);
            }
        }
        return res;
    }
}
