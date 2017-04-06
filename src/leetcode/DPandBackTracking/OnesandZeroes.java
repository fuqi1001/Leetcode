package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/4/6.
 */
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String cur : strs) {
            int[] num = count(cur);
            for(int i = m; i >= num[0]; i--) {
                for(int j = n; j >= num[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-num[0]][j-num[1]]);
                }
            }
        }
        return dp[m][n];
    }
    private int[] count(String str) {
        int[] num = new int[2];
        for(char c : str.toCharArray()) {
            num[c-'0']++;
        }
        return num;
    }
}
