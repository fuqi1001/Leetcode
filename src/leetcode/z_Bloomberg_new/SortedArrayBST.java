package leetcode.z_Bloomberg_new;

public class SortedArrayBST {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertBST(nums, 0, nums.length - 1);
    }

    private TreeNode convertBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode currNode = new TreeNode(nums[mid]);
        currNode.left = convertBST(nums, left, mid - 1);
        currNode.right = convertBST(nums, mid + 1, right);
        return currNode;
    }
}
