package leetcode.Tree;

import java.util.HashMap;

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


    //----------------


    public TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length - 1, postorder, 0 , postorder.length - 1, map);

    }
    private TreeNode helper(int[] inorder,int istart, int iend, int[] postorder, int pstart, int pend, HashMap<Integer,Integer> map){
       if(pstart > pend || istart > iend) return null;

        TreeNode root = new TreeNode(postorder[pend]);

        int position = map.get(postorder[pend]);

        TreeNode leftChild = helper(inorder, istart, position - 1, postorder, pstart, pstart+position-istart - 1,map);
        TreeNode rightChild = helper(inorder, position+1,iend, postorder, pstart + position - istart,pend-1,map);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
