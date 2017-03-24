package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/3/24.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }
    private void generate(List<String> res, String cur, int open, int close, int count) {
        if(cur.length() == count * 2) {
            res.add(cur);
            return;
        }
        if(open < count) {
            generate(res, cur+"(" , open + 1, close, count);
        }
        if(close < open) {
            generate(res, cur+")", open, close + 1, count);
        }
    }

    /*
    每次尝试添加 "(" 后, 尝试添加 ")", 保证括号的有效
     */
}
