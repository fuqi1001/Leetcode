package leetcode.z_Bloomberg_new;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        recurChecker(res, digits, new StringBuilder(), 0);
        return res;
    }
    public void recurChecker(List<String> res, String digits, StringBuilder sb, int position) {
        if (position == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String curDigitStr = KEYS[digits.charAt(position) - '0'];
        for(int i = 0; i < curDigitStr.length(); i++) {
            char c = curDigitStr.charAt(i);
            int curSbLen = sb.length();
            recurChecker(res, digits, sb.append(c), position + 1);
            sb.setLength(curSbLen);
        }
    }
}
