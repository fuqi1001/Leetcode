package leetcode.twoPoint;

/**
 * Created by qifu on 16/9/20.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        for(int i = 0 ; i < haystack.length() ; i++){
            if(haystack.length()-i+1 < needle.length()) return -1;

            int k = i;
            int j = 0;
            while(j < needle.length() && k < haystack.length() && needle.charAt(j) == haystack.charAt(k)){
                j++;
                k++;
                if(j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int[] next = this.getNextArr(needle);
        int m=haystack.length(),n=needle.length();
        int i=0,j=0;

        while (m-i >= n-j && m>i) {
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else if(j==0){
                i++;
            }else{
                j = next[j-1];
            }
            if(j == n) return i-j;
        }

        return -1;
    }

    private int[] getNextArr(String s) {

        int len = s.length();
        int[] next = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(next[i-1]) == s.charAt(i)) {
                next[i] = next[i - 1] + 1;
            } else if (s.charAt(0) == s.charAt(i)) {
                next[i] = 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }
}
