package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/16.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        if(n <= 0) return result;

        helper(result,"",n,n);
        return result;
    }
    public void helper(ArrayList<String> list, String paren, int left,int right){
        if(left == 0 && right == 0) {
            list.add(paren);
            return;
        }
        if(left > 0){
            helper(list,paren+"(",left - 1,right);
        }
        if(right > 0 && left < right){
            helper(list,paren+")",left,right - 1);
        }
    }
}
