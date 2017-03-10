package leetcode.other;

/**
 * Created by qifu on 17/3/10.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];

        for(int i = 0 ;i <= num; i++){
            int count = 0;
            int cur = i;

            while( cur > 0) {
                count += cur & 1;
                cur >>= 1;
            }
            res[i] = count;
        }
        return res;
    }

    //
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for(int i = 0; i <= num; i++){
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }
}
