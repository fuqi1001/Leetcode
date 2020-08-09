package leetcode.z_rot;

public class BreakPalindrome {
    public String breakPalin(String str) {
        char[] s = str.toCharArray();
        int len = str.length();
        for(int i = 0; i < len; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }
        s[len - 1] = 'b';
        return len < 2 ? "" : String.valueOf(s);
    }
}
