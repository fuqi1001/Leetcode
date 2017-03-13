package leetcode.other;

/**
 * Created by qifu on 17/3/13.
 */
public class ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
        if(num == 0) return "0";
        String res = "";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(num != 0) {
            res = map[num & 15] + res;
            num >>>= 4;
        }
        return res;
    }
}
