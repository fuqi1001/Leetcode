package leetcode.other;

/**
 * Created by qifu on 17/7/23.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int start = i;
            int length = 0;
            while(start + length < s.length()) {
                int end = start + length + 1;
                String temp = s.substring(start, end);
                //System.out.println(temp);
                if(check(temp)) {
                    count++;
                }
                length++;
            }
        }
        return count;
    }
    public boolean check(String cur) {
        String str = new StringBuilder(cur).reverse().toString();
        return str.equals(cur);

    }
}
