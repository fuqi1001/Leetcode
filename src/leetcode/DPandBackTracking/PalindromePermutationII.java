package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/2/6.
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<Character> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        // step 1. build character count map and count odds
        for(int i = 0 ; i < s.length(); i++){
            char cur = s.charAt(i);
            map.put(cur, map.containsKey(cur) ? map.get(cur) + 1 : 1);
            odd += map.get(cur) % 2 != 0 ? 1 : -1;
        }
        // cannot form any palindromic string
        if(odd > 1) return res;




        // step 2. add half count of each character to list
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();

            if(val % 2 != 0) mid += key;
            for(int i = 0 ; i < val / 2; i++){
                list.add(key);
            }
        }
        // step 3. generate all the permutations
        helper(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }

    private void helper(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res){
        if(sb.length() == list.size()){
            String curRes = sb.toString() + mid + sb.reverse().toString();
            res.add(curRes);
            sb.reverse();
            return;
        }
        for(int i = 0; i < list.size(); i++){
            // avoid duplication
            if(i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

            if(!used[i]){
                used[i] = true;
                sb.append(list.get(i));
                //recursion
                helper(list,mid,used,sb,res);
                used[i] = false;
                //backtracking
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
