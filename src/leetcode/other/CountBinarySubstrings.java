package leetcode.other;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int prevLen = 0, curLen = 1, currNum = (int)s.charAt(0), res = 0;
        for(int i = 1; i < s.length(); i++) {
            if((int)s.charAt(i) == currNum) curLen++;
            else {
                prevLen = curLen;
                currNum = (int)s.charAt(i);
                curLen = 1;
            }
            if(prevLen >= curLen) res++;
        }
        return res;
    }
}
