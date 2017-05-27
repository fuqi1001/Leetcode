package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 17/2/10.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String cur : tokens) {
            if( !cur.equals("+") && !cur.equals("-") && !cur.equals("*") && !cur.equals("/")) {
                stack.push(Integer.parseInt(cur));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(cur.equals("+")) {
                    stack.push(num1 + num2);
                } else if(cur.equals("-")) {
                    stack.push(num2 - num1);
                } else if(cur.equals("*")) {
                    stack.push(num1 * num2);
                } else if(cur.equals("/")) {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }
    /*
    remember to use equals()
     */
}
