package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 16/10/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> stack_num = new Stack<>();
        Stack<String> stack_str = new Stack<>();
        String result_str = "";
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(Character.isDigit(c)) {
                int num = 0;
                while(Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                stack_num.push(num);
            } else if(c == '[') {
                stack_str.push(result_str);
                result_str = "";
                index++;
            } else if(c == ']') {
                StringBuilder sb = new StringBuilder(stack_str.pop());
                int times = stack_num.pop();
                for(int i = 0; i < times; i++) {
                    sb.append(result_str);
                }
                result_str = sb.toString();
                index++;
            } else {
                result_str += c;
                index++;
            }
        }
        return result_str;
    }

}
