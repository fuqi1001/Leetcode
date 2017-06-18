package leetcode.other;

/**
 * Created by qifu on 17/6/17.
 */
public class MinimumFactorization {
    public int smallestFactorization(int a) {
        if(a < 10) return a;
        int[] res = new int[32];
        int i = 0, j = 0;
        for(i = 9; i > 1; i--) {
            while(a % i == 0) {
                if(j >= 10) return 0;
                a /= i;
                res[j] = i;
                j++;
            }
        }
        if(a > 10) return 0;
        StringBuilder sb = new StringBuilder();
        for(i = j - 1; i >= 0; i--) {
            sb.append(res[i]);
        }
        String r = sb.toString();
        try {
            return Integer.parseInt(r);
        } catch(NumberFormatException n) {
            return 0;
        }
    }

    /*
    从最大的digit也就是'9'开始除肯定能得到最小的数字
    最后用try catch处理overflow
     */
}
