package leetcode.z_Bloomberg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 17/3/6.
 */
public class refactorTree {
    /*
    *
    * 把一个binary search tree里面的node的值，换成这个树里面比它大的值的和。
        比如
         2.
       1    3
    转换完后，变成
          5
        6  3
    *
    * */


    public static void refactorTree(TreeNode root) {
        if(root == null) return;
        List<TreeNode> list = new LinkedList<>();
        inorder(root, list);
        int size = list.size();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){

            nums[i] = list.get(i).val;

        }
        helper(root, nums);
        System.out.println(root.val +" "+ root.left.val + " " + root.right.val);

    }
    public static void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) return ;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    public static void helper(TreeNode root, int[] nums) {
        int count = 0;
        if(root == null) return;
        helper(root.left, nums);
        //System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);

        for(int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] <= root.val){
                //System.out.println(root.val +" "+ nums[i]);
                break;
            }
            count += nums[i];

        }
        root.val += count;
        helper(root.right, nums);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        refactorTree(root);

    }
}
