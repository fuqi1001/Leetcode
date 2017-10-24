package leetcode.z_Bloomberg;

public class ZUMA {
    public static String zuma(String s) {
        if(s == null || s.length() < 3) return s;
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            int move = i;
            while(move < s.length() - 1 && s.charAt(move) == s.charAt(move + 1)) {
                move++;
            }
            if(move - i + 1 <= 2) {
                res += s.substring(i, move+1);
            }
            i = move;
        }
        if(res.length() == s.length()) return s;
        return zuma(res);
    }
}
