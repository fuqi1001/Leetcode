package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 17/2/8.
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if(!s.startsWith("[")) {
            return new NestedInteger(Integer.valueOf(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        int start = 1;
        NestedInteger res = new NestedInteger();
        stack.push(res);

        for(int i = 1; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '['){
                NestedInteger cur_nest = new NestedInteger();
                stack.peek().add(cur_nest);
                stack.push(cur_nest);
                start = i + 1;
            } else if( cur == ',' || cur ==']'){
                if(i > start) {
                    Integer val = Integer.valueOf(s.substring(start, i));
                    stack.peek().add(new NestedInteger(val));
                }
                start = i + 1;
                if(cur == ']'){
                    stack.pop();
                }
            }

            /*
            如果碰到数字,会持续往下走并不进行操作
            对数字的操作只需要substring即可
             */
        }
        return res;
    }
}
