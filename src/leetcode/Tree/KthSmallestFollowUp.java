package leetcode.Tree;

public class KthSmallestFollowUp {
    class TreeNodeWithCount {
        int val;
        int count; //count how many node in left child;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        public TreeNodeWithCount(int x) {
            this.val = val;
            count = 1;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
    }

    private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if(root == null) return null;
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if(rootWithCount.left != null) rootWithCount.count += rootWithCount.left.count;
        if(rootWithCount.right != null) rootWithCount.count += rootWithCount.right.count;
        return rootWithCount;
    }

    private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if(k <= 0 || k > rootWithCount.count) return -1;
        if(rootWithCount.left != null) {
            if(rootWithCount.left.count >= k) return kthSmallest(rootWithCount.left, k);
            if(rootWithCount.left.count == k) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k - 1- rootWithCount.left.val);
        } else {
            if(k == 1) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k - 1);
        }
    }
}
