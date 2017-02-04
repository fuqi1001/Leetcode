package leetcode.other;

/**
 * Created by qifu on 17/2/4.
 */
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String cur: strs){
            int[] cnt = count(cur);
            for(int i = m; i >= cnt[0]; i--){
                for(int j = n; j >= cnt[1]; j--){
                    dp[i][j] = Math.max(1 + dp[i - cnt[0]][j - cnt[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    private int[] count(String cur){
        int[] res = new int[2];
        for(int i = 0 ; i < cur.length(); i++){
            res[cur.charAt(i) - '0']++;
        }
        return res;
    }
}
