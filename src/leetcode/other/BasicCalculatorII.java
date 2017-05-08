package leetcode.other;

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
    /*
    用sign 记录前一个符号,这样每次都能取当前数字和stack顶端数字进行计算
    每次计算完后讲得到的结果压回栈中
    最后将栈中元素进行累加

     */
}
