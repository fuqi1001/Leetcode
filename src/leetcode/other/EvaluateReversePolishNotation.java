package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 17/2/10.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        for(String cur : tokens){
            if(cur.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if(cur.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if(cur.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if(cur.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(cur));
            }
        }
        return stack.pop();
    }
}
