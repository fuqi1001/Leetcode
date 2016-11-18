package leetcode.DPandBackTracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qifu on 16/11/18.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        return dfs(s,0,wordDict,set);

    }

    private boolean dfs(String s, int index, Set<String> dict, Set<Integer> set){
        if(index == s.length()) return true;
        if(set.contains(index)) return false;

        for(int i = index+1; i <= s.length() ; i++){
            String temp = s.substring(index, i);
            if(dict.contains(temp)){
                if(dfs(s,i,dict,set)){
                    return true;
                }else{
                    set.add(i);
                }
            }
        }

        set.add(index);
        return false;
    }
}
