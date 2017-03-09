package leetcode.z_Bloomberg;

/**
 * Created by qifu on 17/3/9.
 */
public class NumberComplement {
    public int findComplement(int num) {
        int res = 0;
        int x = 1;
        while(num > 0) {

            res += (num & 1) == 1 ? 0 : x;
            num >>= 1;
            x *= 2;
        }
        return res;
    }
}
