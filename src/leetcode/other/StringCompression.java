package leetcode.other;

public class StringCompression {
    public int compress(char[] chars) {
        int index = 0, len = chars.length, count = 1;
        for(int i = 1; i <= len; i++) {
            if(i < len && chars[i] == chars[i - 1]) {
                count++;
                continue;
            }
            chars[index++] = chars[i - 1];
            if(count != 1) {
                String num = String.valueOf(count);
                for(char c : num.toCharArray()) {
                    chars[index++] = c;
                }
            }
            count = 1;
        }
        return index;
    }
}
