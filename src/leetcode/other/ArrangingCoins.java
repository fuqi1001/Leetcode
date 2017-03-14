package leetcode.other;

/**
 * Created by qifu on 16/12/31.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n){
        return (int) ((Math.sqrt(8 * (long)n + 1) - 1) * 0.5);
    }

    //
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) >>> 1;
            if(0.5 * mid * mid + 0.5 * mid <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
