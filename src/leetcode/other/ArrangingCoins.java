package leetcode.other;

/**
 * Created by qifu on 16/12/31.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n){
        return (int) ((Math.sqrt(8 * (long)n + 1) - 1) * 0.5);
    }


    public int arrangeCoins(int n) {
        long nLong = (long)n;

        long start = 0;
        long end = (n / 2) + 1;

        long mid = 0;

        while(start <= end){
            mid = start + (end - start) / 2;


            if(mid * (mid + 1) <= 2 * nLong){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return (int)(start - 1);
    }
}
