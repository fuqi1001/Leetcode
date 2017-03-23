package leetcode.bit;

/**
 * Created by qifu on 17/3/22.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int indexs = 0;
        int indext = 0;
        while(indext < t.length()) {
            if(s.charAt(indexs) == t.charAt(indext)) {
                indexs++;
                if(indexs == s.length()) return true;
            }
            indext++;
        }
        return false;
    }

    //
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int index = -1;
        for(int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if(index == -1) return false;
        }
        return true;
    }
}
