package leetcode.z_Bloomberg_new;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> number = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while(idx < s.length()) {
            char curr = s.charAt(idx);
            if (Character.isDigit(curr)) {
                int count = 0;
                while(Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                number.push(count);
            } else if(s.charAt(idx) == '['){
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTime = number.pop();
                for(int i = 0; i < repeatTime; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    // recurise
    private int index = 0;
    public String deStr(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == '[') {
                String str = deStr(s);          // index is global, so next round recur will start from index
                for(int k = 0; k < num; k++) {
                    sb.append(str);
                }
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
