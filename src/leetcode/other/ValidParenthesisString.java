package leetcode.other;

import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack1.push(i);
            } else if(s.charAt(i) == '*') {
                stack3.push(i);
            } else if(s.charAt(i) == ')') {
                if(stack1.isEmpty() && stack3.isEmpty()) return false;
                else if(!stack1.isEmpty()) {
                    stack1.pop();
                } else if( !stack3.isEmpty()) {
                    stack3.pop();
                }
            }
        }

        if(stack1.isEmpty()) return true;
        else {
            if(stack1.size() > stack3.size()) return false;
            else {
                while(!stack1.isEmpty()) {
                    if(stack1.peek() < stack3.pop()) {
                        stack1.pop();
                    }

                    if(stack3.isEmpty() && !stack1.isEmpty()) return false;
                }
            }
        }
        return true;
    }
}
