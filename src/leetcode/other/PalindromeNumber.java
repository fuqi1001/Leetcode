package leetcode.other;

/**
 * Created by qifu on 16/9/15.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 ||(x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while(x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev/10;
    }

    //
    public boolean isPalindrome(int x) {
        if( x < 0) return false;

        int div = 1;
        while(x / div >= 10){
            div *= 10;
        }
        //System.out.println("***"+div);

        while(x > 0){
            //System.out.println("***"+div);
            int left = x / div;
            int right = x % 10;
            if(left != right) return false;
            x = x % div / 10;
            div /= 100;
        }return true;
    }
}
