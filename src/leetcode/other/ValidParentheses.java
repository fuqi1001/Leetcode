package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 16/9/16.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0 || s == null) return true;
        Stack<Character> stack = new Stack<>();
        for(Character ctr : s.toCharArray()){
            if("({[".contains(String.valueOf(ctr))){
                stack.push(ctr);
            }
            else{
                if(!stack.isEmpty() && helper(stack.peek(), ctr)){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();

    }

    public boolean helper(char c1,char c2){
        return (c1 =='(' && c2 ==')') || (c1 =='{' && c2=='}') ||(c1 == '[' && c2 ==']');
    }

}
