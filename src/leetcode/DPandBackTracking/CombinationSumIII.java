package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/11.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        conbination(res, list, 1, k, n);
        return res;
    }
    private void conbination(List<List<Integer>> res, List<Integer> list, int index, int k, int n) {
        if(list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i <= 9; i++) {
            list.add(i);
            conbination(res, list, i + 1, k, n - i);
            list.remove(list.size() - 1);
        }
    }
    //剪枝
    /*
    当 结余n - i < 0 时, 已不能满足合的要求 所以可以停止
    当当前list size大于 k 时, 可以停止查找
    当余下数字不足还需数字时  可以停止查找

     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        conbination(res, list, 1, k, n);
        return res;
    }
    private void conbination(List<List<Integer>> res, List<Integer> list, int index, int k, int n) {
        if(list.size() > k) return;
        if(list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        int right = 9 - k + list.size();
        // System.out.println(right);
        for(int i = index; i <= right + 1; i++) {
            if(n - i >= 0) {
                list.add(i);
                conbination(res, list, i + 1, k, n - i);
                list.remove(list.size() - 1);
            }

        }
    }

}
