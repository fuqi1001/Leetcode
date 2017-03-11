package leetcode.other;

/**
 * Created by qifu on 17/3/11.
 */
public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        return dp(table, 1, n);
    }
    public int dp(int[][] table, int start, int end) {
        if(start >= end) return 0;
        if(table[start][end] != 0) return table[start][end];
        int res = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++) {
            int temp = i + Math.max(dp(table, start, i - 1), dp(table, i + 1, end));
            res = Math.min(res, temp);
        }
        table[start][end] = res;
        return res;
    }
}


    /*
        For each number x in range[i~j]
        we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
        --> // the max means whenever you choose a number,
        // the feedback is always bad and therefore leads you to a worse branch.
        then we get DP([i~j]) = min{xi, ... ,xj}
        --> // this min makes sure that you are minimizing your cost.
       */
