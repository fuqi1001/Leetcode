package leetcode.other;

/**
 * Created by qifu on 16/12/3.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len / 2; i >= 1; i--) {
            if(len % i == 0) {
                int count = len / i;
                String cur = s.substring(0, i);
                int j;
                for(j = 1; j < count; j++) {
                    if(!cur.equals(s.substring(i * j, i + i * j))) break;
                }
                if(count == j) return true;
            }
        }
        return false;
    }
        //

    public boolean repeatedSubstringPattern(String s) {
        for(int i = s.length()/2; i >= 1; i--) {
            if(s.length() % i == 0) {
                int j = i;
                String cur = s.substring(0, j);
                while(s.indexOf(cur, j) == j) j += i;
                if(j == s.length()) return true;
            }
        }
        return false;
    }
}
