package leetcode.other;

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

    //
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int left = 0;
        int right =s.length() - 1;
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            System.out.println(c1 +" "  +c2);
            if(c1 != c2) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    //
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
