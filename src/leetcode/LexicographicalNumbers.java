package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qifu on 16/10/20.
 */
public class LexicographicalNumbers {
    private List<Integer> res ;
    private int n;
    public List<Integer> lexicalOrder(int n) {
        this.res = new ArrayList<>();
        this.n = n;
        solve(1);
        return res;
    }
    private void solve(int m){
        res.add(m);
        if(m * 10 <= n) solve(m * 10);
        if(m < n && m % 10 < 9) solve(m + 1);
    }


    //
    public List<Integer> lexicalOrder(int n){
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(n <= 0 )return res;

        stack.push(1);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            res.add(cur);
            if(cur < n && cur % 10 < 9){
                stack.push(cur+1);
            }
            if(cur * 10 <= n){
                stack.push(cur * 10);
            }
        }
        return res;
    }
}
