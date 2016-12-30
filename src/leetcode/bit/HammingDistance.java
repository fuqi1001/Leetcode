package leetcode.bit;

/**
 * Created by qifu on 16/12/30.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0 ;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }


    public int hammingDistance(int x, int y) {
        int count = Integer.bitCount(x ^ y);
        return count;
    }
}
