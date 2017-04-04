package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/2/3.
 */
public class StrobogrammaticNumberII {
    List<String> res;
    public List<String> findStrobogrammatic(int n) {
        res = new ArrayList<>();
        helper(new char[n], 0, n-1);
        return res;
    }
    private void helper(char[] cur, int left, int right) {
        if(left > right) {
            res.add(new String(cur));
            return;
        }
        if(left == right) {
            cur[left] = '0';
            res.add(new String(cur));
            cur[left] = '1';
            res.add(new String(cur));
            cur[left] = '8';
            res.add(new String(cur));
            return;
        }

        if(left != 0) {
            cur[left] = '0';
            cur[right] = '0';
            helper(cur, left+1,right-1);
        }
        cur[left] = '1';
        cur[right] = '1';
        helper(cur, left+1,right-1);

        cur[left] = '6';
        cur[right] = '9';
        helper(cur, left+1,right-1);

        cur[left] = '8';
        cur[right] = '8';
        helper(cur, left+1,right-1);

        cur[left] = '9';
        cur[right] = '6';
        helper(cur, left+1,right-1);
    }
}
