package leetcode.other;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int left = 0;
        for(int right = s.length() - 1; right >= 0; right--) {
            if(s.charAt(left) == s.charAt(right)) left++;
        }
        if(left == s.length()) return s;
        String suffix = s.substring(left);
        return new StringBuilder(suffix).reverse().toString() +
                shortestPalindrome(s.substring(0, left)) + suffix;
    }
}
