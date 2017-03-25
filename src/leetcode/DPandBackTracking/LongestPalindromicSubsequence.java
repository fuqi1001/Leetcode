package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/3/24.
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i + 1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    /*
    subseq的意思是 可以有间隔的, 不一定非要相邻
     */


    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    private int helper(String s, int start, int end, Integer[][] memo) {
        if(memo[start][end] != null) return memo[start][end];
        if(start > end) return 0;
        if(start == end) return 1;

        if(s.charAt(start) == s.charAt(end)) {
            memo[start][end] = helper(s, start + 1, end - 1, memo) + 2;
        } else {
            memo[start][end] = Math.max( helper(s, start+1, end, memo), helper(s, start, end - 1, memo)    );
        }
        return memo[start][end];
    }
}
