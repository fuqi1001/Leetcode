package leetcode.bit;

/**
 * Created by qifu on 17/4/10.
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for(int cur : data) {
            if(count == 0) {
                if((cur >> 5) == 0b110) count = 1;
                else if((cur >> 4) == 0b1110) count = 2;
                else if((cur >> 3) == 0b11110) count = 3;
                else if((cur >> 7) == 1) return false;
            } else {
                if((cur>>6) != 0b10) return false;
                count--;
            }
        }
        return count == 0;
    }
}
