package leetcode.other;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qifu on 16/10/26.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int i = 0;
        int j = 0;
        int ans = 0;
        for(i = 0 ; i < s.length() ;i++){
            while(j < s.length() && map[s.charAt(j)] == 0){
                map[s.charAt(j)] = 1;
                ans = Math.max(ans,j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        return ans;
    }

    //
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, move = 0;
        int max = 0;
        while(move < s.length()) {
            if(!set.contains(s.charAt(move))) {
                set.add(s.charAt(move));
                move++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }
}
