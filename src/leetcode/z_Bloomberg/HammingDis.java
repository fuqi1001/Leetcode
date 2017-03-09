package leetcode.z_Bloomberg;

/**
 * Created by qifu on 17/3/9.
 */
public class HammingDis {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);     //lol

    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while(xor != 0) {
            res += xor & 1;
            xor >>= 1;
        }
        return res;
    }
}
