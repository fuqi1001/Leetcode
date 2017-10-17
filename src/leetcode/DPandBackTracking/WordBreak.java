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
}
