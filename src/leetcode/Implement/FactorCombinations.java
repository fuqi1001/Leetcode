package leetcode.Implement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/3/27.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, n, 2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int n, int factor) {
        if(n <= 1) {
            if(list.size() > 1) {       //排除facotr只有自身的情况
                res.add(new ArrayList(list));
                return;
            }
        }

        for(int i = factor; i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                helper(res, list, n/i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
