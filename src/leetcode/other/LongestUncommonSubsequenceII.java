package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/4/2.
 */
public class LongestUncommonSubsequenceII {
    //
    public int findLUSlength(String[] strs) {
        int res = -1;
        for(int i = 0, j; i < strs.length; i++) {
            for(j = 0; j < strs.length; j++) {
                if(i == j) continue;
                if(isSub(strs[i], strs[j])) break;
            }
            if(j == strs.length) res = Math.max(res, strs[i].length());
        }
        return res;
    }
    private boolean isSub(String x, String y) {
        int j = 0;
        for(int i = 0; i < y.length() && j < x.length(); i++) {
            if(x.charAt(j) == y.charAt(i)) j++;
        }
        return j == x.length();
    }

    //
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });

        for(int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for(int j = 0; j < strs.length; j++) {
                if(i == j) continue;
                if(isSub(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if(flag) return strs[i].length();
        }
        return -1;
    }

    private boolean isSub(String x, String y) {
        int j = 0;
        for(int i = 0; i < y.length() && j < x.length(); i++) {
            if(x.charAt(j) == y.charAt(i)) j++;
        }
        return j == x.length();
    }






    //

    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap();
        for(String s: strs) {
            for(String cur : getSub(s)) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int res = -1;

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) res = Math.max(res, entry.getKey().length());
        }
        return res;
    }
    private Set<String> getSub(String s) {
        Set<String> res = new HashSet<>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }
        Set<String> subSet = getSub(s.substring(1));
        res.addAll(subSet);
        for(String cur : subSet) {
            res.add(s.charAt(0) + cur);
        }
        return res;
    }
}
