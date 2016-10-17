package leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/17.
 */
public class UnqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return helper(1,n);
    }
    public List<TreeNode> helper(int min, int max){
        List<TreeNode> res = new ArrayList<>();
        if(min > max){
            res.add(null);
            return res;
        }

        for(int i = min ; i <= max ;i++){
            List<TreeNode> left = helper(min,i-1);
            List<TreeNode> right = helper(i+1,max);
            for(int j = 0 ; j < left.size() ;j++){
                for(int k = 0 ; k < right.size();k++ ){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
