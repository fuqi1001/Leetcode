package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/9/15.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if(root == null) return result;
        String str = String.valueOf(root.val);
        helper(root,str,result);
        return result;

    }
    public void helper(TreeNode node , String path, List<String> result){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            result.add(path);
        }
        if(node.left != null){
            path = path+"->"+String.valueOf(node.left.val);
            helper(node.left,path,result);
        }
        if(node.right != null){
            path = path+"->"+String.valueOf(node.right.val);
            helper(node.right,path,result);
        }
    }
}
