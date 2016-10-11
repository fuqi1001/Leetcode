package leetcode.Tree;

/**
 * Created by qifu on 16/10/11.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0) return 0;
        TreeNode node = root;

        while(node!=null){
            if(node.left == null){
                if(k == 1){
                    return node.val;
                }
                k--;
                node = node.right;
            }
            else{
                TreeNode rightmost = node.left;
                while(rightmost.right !=null){
                    rightmost = rightmost.right;
                }

                TreeNode temp = node.left;
                node.left = null;
                rightmost.right = node;
                node = temp;
            }
        }
        return node.val;
    }
}
