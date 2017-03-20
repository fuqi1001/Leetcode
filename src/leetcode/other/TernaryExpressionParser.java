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

    //DFS
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0) return "";
        return DFS(expression.toCharArray(), 0, expression.length() - 1) + "";
    }
    private char DFS(char[] c, int start, int end){
        if(start == end) return c[start];
        int count = 0;
        int i = start;
        for(; i <= end; i++) {
            if(c[i] == '?') {
                count++;
            } else if(c[i] == ':'){
                count--;
                if(count == 0) break;
            }
        }
        return c[start] == 'T' ? DFS(c, start + 2, i -1) : DFS(c, i + 1, end);
    }
}
