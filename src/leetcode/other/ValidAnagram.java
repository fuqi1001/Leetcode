package leetcode.other;

import com.sun.tools.hat.internal.util.ArraySorter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by qifu on 16/8/19.
 */
public class ValidAnagram {

    // best
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        //one 'char' type takes 8bits. 256 char values at most.
        int[] srecord = new int[256];
        int[] trecord = new int[256];
        int len = s.length();
        for(int i = 0; i < len; ++i){
            srecord[ss[i]] ++;
            trecord[ts[i]] ++;
        }
        for(int i = 0; i <  256; ++i){
            if(srecord[i] != trecord[i])
                return false;
        }
        return true;
    }


    public boolean isAnagram(String s, String t) {

        HashMap<Character,Integer> set1 = new HashMap();

        for(int i = 0 ; i < s.length() ; i++){
            char ctr = s.charAt(i);
            if(set1.containsKey(ctr)){
                set1.put(ctr,set1.get(ctr)+1);
            }
            else{
                set1.put(ctr,1);
            }
        }

        for(int i = 0 ; i < t.length() ; i++){
            char ctr = t.charAt(i);
            if(set1.containsKey(ctr) == false) return false;
            else{
                if(set1.get(ctr) - 1 == 0){
                    set1.remove(ctr);
                }
                else{
                    set1.put(ctr,set1.get(ctr) - 1);
                }
            }
        }

        return set1.size() == 0;

    }

    public boolean isAnagram(String s,String t){
        if(t.length() != s.length()) return false;
        if(t.length() == 0 && s.length() == 0) return true;

        char[] set1 = s.toCharArray();
        char[] set2 = t.toCharArray();

        Arrays.sort(set1);
        Arrays.sort(set2);

        for(int i = 0 ; i < set1.length ;i++){
            if(set1[i] != set2[i]) return false;
        }
        return true;
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            count[c - 'a']--;
            if(count[c - 'a'] < 0) return false;
        }
        return true;
    }


    //
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] num = new int[26];
        for(int i = 0; i < s.length(); i++){
            num[s.charAt(i) - 'a']++;
            num[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(num[i] != 0) return false;
        }
        return true;
    }
}
