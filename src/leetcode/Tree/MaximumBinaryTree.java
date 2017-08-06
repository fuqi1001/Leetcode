package leetcode.Tree;

/**
 * Created by qifu on 17/8/6.
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int left = 0, right = nums.length - 1;
        return help(left, right, nums);
    }
    public TreeNode help(int left, int right, int[] nums) {
        if(left < 0 || right >= nums.length) return null;
        if(left == right) return new TreeNode(nums[left]);
        int max = 0;
        int index = 1001;

        for(int i = left; i <= right; i++) {
            if(max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        if(max == 0) return null;
        TreeNode node = new TreeNode(max);
        node.left = help(left, index - 1, nums);
        node.right = help(index + 1, right, nums);
        return node;
    }
}
