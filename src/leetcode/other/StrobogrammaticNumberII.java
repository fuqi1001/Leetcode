package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/2/3.
 */
public class StrobogrammaticNumberII {
    List<String> res = new ArrayList<>();
    public List<String> findStrobogrammatic(int n) {
        helper(new char[n],0,n - 1 );
        return res;
    }
    private void helper(char[] a, int left, int right){
        if(left > right){
            res.add(new String(a));
            return;
        }
        if(left == right){
            a[left] = '0';
            res.add(new String(a));
            a[left] = '1';
            res.add(new String(a));
            a[left] = '8';
            res.add(new String(a));
            return;
        }

        if(left != 0){
            a[left] = '0';
            a[right] = '0';
            helper(a, left + 1, right - 1);
        }

        a[left] = '1';
        a[right] = '1';
        helper(a, left + 1, right - 1);

        a[left] = '8';
        a[right] = '8';
        helper(a, left + 1, right - 1);

        a[left] = '6';
        a[right] = '9';
        helper(a, left + 1, right - 1);

        a[left] = '9';
        a[right] = '6';
        helper(a, left + 1, right - 1);
    }
}
