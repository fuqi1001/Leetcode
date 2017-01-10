package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 17/1/10.
 */
public class TernaryExpressionParser {
    public String parseTernary(String expression){
        if(expression == null || expression.length() == 0) return "";

        Stack<Character> stack = new Stack<>();

        for(int i = expression.length() - 1; i >= 0; i--){
            char cur = expression.charAt(i);
            if(!stack.isEmpty() && stack.peek() == '?'){
                stack.pop(); // pop ?
                char first = stack.pop();
                stack.pop(); // pop :
                char second = stack.pop();

                if(cur == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(cur);
            }
        }
        return String.valueOf(stack.peek());
    }
}
