package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/11/1.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        helper(res,cur,s,0);
        return res;
    }

    public void helper(List<List<String>> res, List<String> cur, String s, int left){
        if(cur.size() > 0 && left >= s.length() ){
            res.add(new ArrayList<>(cur));
        }

        for(int i = left ; i < s.length() ; i++){
            if(isPalindrome(s,left,i)){
                if(left == i){
                    cur.add(Character.toString(s.charAt(i)));
                }else{
                    cur.add(s.substring(left,i + 1));
                }

                helper(res,cur,s,i+1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int left, int right){
        if(left == right) return true;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }
}
