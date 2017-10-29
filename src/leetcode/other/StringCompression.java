package leetcode.other;

public class StringCompression {
    public int compress(char[] chars) {
        int len = chars.length, count = 1, index = 0;
        for(int i = 1; i <= len; i++) {
            if(i < len && chars[i] == chars[i - 1]){
                count++;
                continue;
            }
            chars[index++] = chars[i - 1];
            if(count != 1) {
                String s = Integer.toString(count);
                for(int k = 0; k < s.length(); k++) {
                    chars[index++] = s.charAt(k);
                }
            }
            count = 0;
            count++;
        }
        return index;
    }
}
