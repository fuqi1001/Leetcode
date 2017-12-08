package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 16/11/1.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int maxLen = 0, start = 0, end = 0, len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j+1][i-1] == 1)) {
                    dp[j][i] = 1;
                }
                if(dp[j][i] == 1 && maxLen < i - j + 1) {
                    maxLen = i - j + 1;
                    start = j;
                    end = i;
                }
            }
            dp[i][i] = 1;
        }
        return s.substring(start, end + 1);
    }


    //https://discuss.leetcode.com/topic/60549/java-soultion-beat-99-41-use-the-function-two-point/2
    public String longestPalindrome(String s) {
        if(s.length() == 1 || s.length() == 0) return s;
        char[] chs = s.toCharArray();
        int left = 0;
        int right = 0;
        int position = 0;
        int len = chs.length;

        while(len - position > (right - left) / 2){
            int temp = position + 1;
            if(temp == len) break;
            while(chs[position] == chs[temp]){
                temp++;
                if(temp == len) break;
            }
            int[] re = helper(position - 1,temp,chs);

            if(re[1] - re[0] > right - left){
                right = re[1];
                left = re[0];
            }
            position = temp;

        }
        StringBuilder res = new StringBuilder();
        for(int i = left ; i <= right; i++){
            res.append(chs[i]);
        }
        return res.toString();

    }

    private int[] helper(int left, int right, char[] chs){
        int[] re = new int[2];
        while(left>=0 && right < chs.length){
            if(chs[left] != chs[right]){
                break;
            }
            left--;
            right++;
        }
        re[0] = left + 1;
        re[1] = right - 1;
        return re;
    }


    ///
    int lo, maxLen;

    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        for(int i = 0; i < s.length(); i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo + maxLen);
    }
    public void extendPalindrome(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(maxLen < end - start - 1){
            lo = start + 1;
            maxLen = end - start - 1;
        }
    }
}
