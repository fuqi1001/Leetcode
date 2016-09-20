package leetcode;

import java.util.Arrays;

/**
 * Created by qifu on 16/9/20.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs ==null || strs.length ==0) return "";

        String prefix = strs[0];
        for(int i = 0 ;i < strs.length;i++){
            int j = 0;
            while(j < strs[i].length() && j < prefix.length()&& strs[i].charAt(j) ==prefix.charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
    public String longestCommonPrefix(String[] strs){
        StringBuilder result = new StringBuilder();
        if(strs == null || strs.length == 0) return result;
        for(int i = 0 ; i < strs[0].length() ; i++){
            for(int j = 1; j < strs.length ;j++){
                if(i > strs[i].length() || strs[0].charAt(j) != strs[j].charAt(i)){
                    return result.toString();
                }
                result.append(strs[0].charAt(i));
            }
        }
        return result.toString();
    }

    //sort完对比头尾两个,因为头尾两个差异最大

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length -1 ].toCharArray();

        for(int i = 0 ; i < a.length ; i++){
            if(i < b.length && a[i] == b[i])
                result.append(a[i]);
            else
                return result.toString();
        }

        return result.toString();
    }
}
