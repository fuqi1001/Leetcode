package leetcode.bit;

/**
 * Created by qifu on 16/12/2.
 */
public class ConvertaNumbertoHexadecimal {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        String res = "";
        if(num == 0) return "0";
        while(num != 0){
            res = map[(num & 15)] + res;
            num = num >>> 4;
        }
        return res;
    }
}
