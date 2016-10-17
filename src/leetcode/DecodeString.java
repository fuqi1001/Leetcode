package leetcode;

import java.util.Stack;

/**
 * Created by qifu on 16/10/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        String res = "";
        if(s == null || s.length() == 0)return res;

        int count = 0;
        String temp = "";
        for(int i = 0 ; i < s.length() ;i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                count = count * 10 + s.charAt(i)-'0';
            }
            else if(s.charAt(i) == '['){
                num.push(count);
                str.push(temp);
                count = 0;
                temp ="";
            }
            else if(s.charAt(i) == ']'){
                int cur_num = num.pop();
                String cur_str = str.pop();
                //System.out.println("num:" +cur_num);
                for(int j = 0 ; j < cur_num ;j++){
                    cur_str += temp;
                }
                temp = cur_str;
            }
            else{
                temp += s.charAt(i);
            }
        }
        if(str.isEmpty()){
            return temp;
        }else{
            return str.pop();
        }
    }

    int i = 0;
    public String decodeString(String s) {
        if(s.length() == 0) return "";
        return helper(s,0);
    }
    private String helper(String s, int index){
        if(index >= s.length()){
            return "";
        }
        StringBuilder number = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for(i = index ; i < s.length() ;i++ ){
            if(Character.isDigit(s.charAt(i))){
                number.append(s.charAt(i));
            }
            if(Character.isLetter(s.charAt(i))){
                str.append(s.charAt(i));
            }
            if(s.charAt(i) == '['){
                System.out.println("1: "+i);
                String next_str = helper(s,i+1);
                System.out.println("2: "+i);
                //System.out.println("num: "+ number.toString());
                for(int j = 0 ; j < Integer.valueOf(number.toString());j++){
                    str.append(next_str);
                }
                number.delete(0,number.length());
            }else if(s.charAt(i) == ']'){
                return str.toString();
            }
        }
        return str.toString();
    }

}
