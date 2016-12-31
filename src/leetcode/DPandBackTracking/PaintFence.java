package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/12/31.
 */
public class PaintFence {

    public int numWays(int n, int k){
        int dif = k * (k + 1);
        int same = k;

        if(n == 0) return 0;
        if(n == 1) return k;

        for(int i = 2; i < n ;i++){
            int temp = dif;
            dif = (dif + same) * (k - 1);
            same = temp;
        }

        return dif + same;
    }
}
