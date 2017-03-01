package leetcode.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder,0,inorder.length - 1, postorder,0,postorder.length-1, map);
    }

    /*private int findPosition(int[] arr,int start,int end, int key){
        int i;
        for(i = start ; i <= end ;i++){
            if(arr[i] == key) return i;
        }
        return -1;
    }*/

    private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int postart, int poend, Map<Integer, Integer> map){
        if(instart > inend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[poend]);

        //int position = findPosition(inorder,instart,inend,postorder[poend]);
        int position = map.get(postorder[poend]);
        root.left = helper(inorder,instart,position-1, postorder, postart, postart+position - instart -1, map);
        root.right = helper(inorder, position+1, inend, postorder, postart + position - instart,poend-1, map);

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

    ///
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        int inend = inorder.length - 1;
        int pend = postorder.length - 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[pend]);
        TreeNode prev = null;
        stack.push(root);
        pend--;
        while(pend >= 0) {
            while(!stack.isEmpty() && stack.peek().val == inorder[inend]) {
                prev = stack.pop();
                inend--;
            }
            TreeNode newNode = new TreeNode(postorder[pend]);
            if(prev != null) {
                prev.left = newNode;
            } else if(!stack.isEmpty()){
                TreeNode curtop = stack.peek();
                curtop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pend--;
        }
        return root;
    }
}
