package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/3/24.
 */
public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        /*
        skip表示 1-3 , 3-1 跨过了2, 要标记出来
         */
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
        boolean[] visited = new boolean[10];
        int res = 0;
        /*
        因为 1 3 7 9, 2 4 6 8是对称的,
        所以计算的时候只要count各类中的一个就行了,得出的结果* 4就是全部同一类里4个点的结果和
         */
        for(int i = m; i <= n; i++) {
            res += count(visited, skip, 1, i - 1) * 4;
            res += count(visited, skip, 2, i - 1) * 4;
            res += count(visited, skip, 5, i - 1);
        }
        return res;

    }
    public int count(boolean[] visited, int[][] skip, int cur, int remain) {
        if(remain < 0) return 0;
        if(remain == 0) return 1;   //说明找到一组;
        int res = 0;
        visited[cur] = true;
        for(int i = 1; i <= 9; i++) {
            if(!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
                res += count(visited, skip, i, remain - 1);
                /*
                如果 i未被访问
                并且当前点cur到i不存在skip点, 或者skip点已备访问
                i与cur能构成一组
                递归往下求解
                 */
            }
        }
        visited[cur] = false;
        return res;
    }
}
