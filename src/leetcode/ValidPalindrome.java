package leetcode;

/**
 * Created by qifu on 16/9/22.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s){
        if(s.length() == 0|| s == null) return true;

        int front = 0;
        int end = s.length() - 1;
        char c1,c2;
        while(front < end){
            c1 = s.charAt(front);
            c2 = s.charAt(end);
            if(!Character.isLetterOrDigit(c1)){
                front++;
            }
            else if(!Character.isLetterOrDigit(c2)){
                end--;
            }
            else{
                if(Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
                front++;
                end--;
            }
        }
        return true;
    }
}
