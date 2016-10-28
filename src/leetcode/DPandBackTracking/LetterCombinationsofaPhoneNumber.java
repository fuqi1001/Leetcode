package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by qifu on 16/10/28.
 */
public class LetterCombinationsofaPhoneNumber {
    int resSize ;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0 ) return res;
        resSize = digits.length();
        String[] str = new String[8];
        str[0] = "abc";
        str[1] = "def";
        str[2] = "ghi";
        str[3] = "jkl";
        str[4] = "mno";
        str[5] = "pqrs";
        str[6] = "tuv";
        str[7] = "wxyz";
        StringBuilder cur = new StringBuilder();

        helper(res,cur,str,0,digits);
        return res;
    }
    public void helper(List<String> res, StringBuilder cur, String[] str, int size, String digits){

        if(cur.length() == resSize) {
            res.add(cur.toString());
            return;
        }

        String curStr = str[(digits.charAt(size) - '0') - 2];

        int len = curStr.length();
        for(int i = 0 ; i < len ;i++){

            cur.append(curStr.charAt(i));

            helper(res,cur,str,size+1,digits);

            cur.deleteCharAt(cur.length()-1);
            size = cur.length();
        }
    }

}
