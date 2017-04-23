package leetcode.z_IXL;

import java.util.Stack;

/**
 * Created by qifu on 17/4/22.
 */
public class SortStack {
    public Stack sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            while(!temp.isEmpty() && temp.peek() > cur) {
                stack.push(temp.pop());
            }
            temp.push(cur);
        }
        return temp;
    }
}
