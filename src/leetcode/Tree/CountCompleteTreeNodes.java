package leetcode.Tree;

import java.util.Arrays;

/**
 * Created by qifu on 16/11/19.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return countNodes(root,-1,-1);
    }
    private int countNodes(TreeNode root, int left_height, int right_height){
        if(left_height == -1){
            TreeNode cur = root;
            left_height = 0;
            while(cur != null){
                left_height++;
                cur = cur.left;
            }
        }
        if(right_height == -1){
            TreeNode cur = root;
            right_height = 0;
            while(cur != null){
                right_height++;
                cur = cur.right;
            }
        }

        if(left_height == right_height) return (1 << left_height) - 1;
        else{
            return 1 + countNodes(root.left, left_height - 1, -1) + countNodes(root.right, -1, right_height - 1);
        }
    }

    //

    private static int rightMostDepth(TreeNode root) {  //the depth from root to the right most leave
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }
    public static int countNodes(TreeNode root) {
        int depth = rightMostDepth(root);   //depth of the last full level
        int result = (1 << depth) - 1;  //num of nodes from root to the last full level
        TreeNode cur = root;
        int rootdepth = 1;
        while (cur != null) {
            int leftdepth = rightMostDepth(cur.left);
            if (leftdepth + rootdepth == depth) cur = cur.left; //the partially full level ends within the left subtree
            else {  //ends in the right subtree
                result += (1 << leftdepth - 1); //add the number of nodes in the partially full level within the left subtree
                cur = cur.right;    //continue to search for the end point of partially full level
            }
            rootdepth++;
        }
        return result;
    }

    //Unlike many of the recursive solutions my solution is to iteratively count the the number of nodes in the partially full layer (last layer if exsiting).
    //It first compute the depth of the right most leave of the whole tree which is the depth of a complete tree. Then it compute the depth of right most leave of the left subtree.
    //If they don't equal to each other, the left subtree is complete tree, we add the number of nodes of the last layer of left subtree and move to right subtree.
    //Otherwise we know the right is complete tree and move to the leftsubtree. Repeat the process till the node is null.



    //

    public int height(TreeNode root){
        return root == null ? 0 : 1 + height(root.left);
    }
    public static int countNodes(TreeNode root) {
        int h = height(root);
        int count = 0;
        while(root != null){
            if(height(root.right) == h - 1) {       //左右同高,满二叉树
                count += 1 << h - 1;
                root = root.right;
            } else {                                //完全二叉树,最左边还有额外点,先统计右边
                count += 1 << (h - 2);
                root = root.left;                   //右边统计共h-1层满的, 最后统计左子树多出来的部分
            }
            h--;
        }
        return count;
    }
}
