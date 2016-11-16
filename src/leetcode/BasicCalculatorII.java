package leetcode;

import java.util.Stack;

/**
 * Created by qifu on 16/11/15.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)  >= '0' ){
                num = num * 10 + s.charAt(i) - '0';

            }

            if((s.charAt(i) < '0' && s.charAt(i) != ' ' ) || i == s.length() - 1){
                //System.out.println(s.charAt(i) + " " +num);
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(num * -1);
                if(sign == '*' || sign == '/') {
                    int number = stack.peek();
                    if(sign == '*'){
                        stack.pop();
                        stack.push(number * num);
                    }else if(sign == '/'){
                        stack.pop();
                        //System.out.println(number + " " + num);
                        stack.push(number / num);
                    }
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res =0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
