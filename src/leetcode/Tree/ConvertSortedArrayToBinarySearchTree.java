package leetcode.Tree;

import java.util.Arrays;

/**
 * Created by qifu on 16/10/16.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0 || nums == null) return null;
        return helper(nums,0,nums.length - 1);
    }

    public TreeNode helper(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,start,mid-1);
        root.right = helper(nums,mid+1,end);
        return root;
    }
}
