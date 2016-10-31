package leetcode.Tree;

/**
 * Created by qifu on 16/4/4.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraveral {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) return null;
        return helper(inorder,0,inorder.length - 1, postorder,0,postorder.length-1);
    }

    private int findPosition(int[] arr,int start,int end, int key){
        int i;
        for(i = start ; i <= end ;i++){
            if(arr[i] == key) return i;
        }
        return -1;
    }

    private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int postart, int poend){
        if(instart > inend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[poend]);

        int position = findPosition(inorder,instart,inend,postorder[poend]);
        root.left = helper(inorder,instart,position-1, postorder, postart, postart+position - instart -1);
        root.right = helper(inorder, position+1, inend, postorder, postart + position - instart,poend-1);

        return root;
    }
}
