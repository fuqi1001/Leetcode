package leetcode.other;

/**
 * Created by qifu on 16/10/26.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }
    public int helper(char[] cur, int start, int end, int k) {
        if(end - start < k) return 0;
        int[] count = new int[26];
        for(int i = start; i < end; i++) {
            count[cur[i] - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(count[i]  < k) {
                for(int j = start; j < end; j++) {
                    if(cur[j] == i+'a') {
                        int left = helper(cur, start, j, k);
                        int right = helper(cur, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    //http://www.cnblogs.com/grandyang/p/5852352.html
}
