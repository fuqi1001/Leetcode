package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by qifu on 16/10/28.
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] str = new String[8];
        str[0] = "abc";
        str[1] = "def";
        str[2] = "ghi";
        str[3] = "jkl";
        str[4] = "mno";
        str[5] = "pqrs";
        str[6] = "tuv";
        str[7] = "wxyz";
        StringBuilder sb = new StringBuilder();
        helper(digits, str, 0, res, sb);
        return res;
    }
    private void helper(String digits, String[] str, int index, List<String> res, StringBuilder sb) {
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String option = str[(digits.charAt(index) - '0') - 2];
        for(char c: option.toCharArray()) {
            sb.append(c);
            helper(digits, str, index + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
