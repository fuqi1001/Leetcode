package leetcode.other;

/**
 * Created by qifu on 17/3/15.
 */
public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] temp = new char[4];
        while(!eof && total < n) {
            int count = read4(temp);
            eof = count < 4;
            count = Math.min(count, n - total);

            for(int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            }
        }
        return total;
    }
}
