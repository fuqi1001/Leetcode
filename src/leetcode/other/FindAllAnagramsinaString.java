package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/12/31.
 */
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[256];
        if(s == null || p == null || s.length() == 0|| p.length() == 0) return list;
        for(int i = 0; i < p.length(); i++){
            hash[p.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();

        while(right < s.length()) {
            if(hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if(count == 0) list.add(left);

            if(right - left == p.length()){
                if(hash[s.charAt(left)] >= 0){
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }

        }
        return list;
    }
}
