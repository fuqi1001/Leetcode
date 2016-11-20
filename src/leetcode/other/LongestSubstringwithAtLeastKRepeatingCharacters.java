package leetcode.other;

/**
 * Created by qifu on 16/10/26.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int i = 0;
        int n = s.length();

        while(i + k < n){
            int[] map = new int[26];
            int mask = 0;
            int max_index = i;
            for(int j = i ; j < n ;j++){
                int t = s.charAt(j) - 'a';
                map[t]++;
                if(map[t] < k) mask |= (1 << t);
                else mask &= (~(1<<t));
                if(mask == 0){
                    res = Math.max(res,j - i + 1);
                    max_index = j;
                }
            }
            i = max_index + 1;
        }
        return res;
    }

    //http://www.cnblogs.com/grandyang/p/5852352.html
}
