package leetcode.bit;

/**
 * Created by qifu on 16/10/27.
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        public int rangeBitwiseAnd(int m, int n) {
            int p = 0;
            while(m != n){
                m = m >> 1;
                n = n >> 1;
                p++;
            }
            return m << p;
        }

        //公共左首部

    }
    public int rangeBitwiseAnd(int m, int n){
        if (n == m){
            return m;
        }
        if(n - m  == 1){
            return n & m;
        }
        return rangeBitwiseAnd(m / 2, n / 2) << 1;
    }


    public int rangeBitwiseAnd(int m, int n){
        int i = 0;
        for(; i<32; i ++)
            if(m>>i == n >>i)
                break;
        return m>>i << i;
    }
}
