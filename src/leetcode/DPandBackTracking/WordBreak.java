package leetcode.DPandBackTracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 16/11/18.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> notValid = new HashSet<>();
        return helper(s, wordDict, notValid, 0);
    }
    public boolean helper(String s, List<String> wordDict, Set<Integer> notValid, int index){
        if(index == s.length()) return true;
        if(notValid.contains(index)) return false;

        for(int i = index + 1; i < s.length() + 1; i++){
            String temp = s.substring(index, i);
            if(wordDict.contains(temp)){
                if(helper(s, wordDict, notValid, i)){
                    return true;
                } else {
                    notValid.add(i);
                }
            }
        }
        notValid.add(index);
        return false;
    }



    //
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
