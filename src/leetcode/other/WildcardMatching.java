package leetcode.other;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int ps = 0, pp = 0, match = 0, startIndex = -1;
        while(ps < s.length()) {
            if(pp < p.length() && (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(ps))) {
                ps++;
                pp++;
            } else if(pp < p.length() && p.charAt(pp) == '*') {
                startIndex = pp;
                match = ps;
                pp++;
            } else if(startIndex != -1) {
                pp = startIndex + 1;
                match++;
                ps = match;
            } else return false;
        }

        while(pp < p.length() && p.charAt(pp) == '*') pp++;
        return pp == p.length();
    }
}
