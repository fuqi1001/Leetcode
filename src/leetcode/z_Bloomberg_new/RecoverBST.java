package leetcode.z_Bloomberg_new;

public class RecoverBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    private TreeNode firstNode = null;
    private TreeNode secondNode = null;
    private TreeNode prevNode = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (prevNode != null && prevNode.val >= node.val) {
            if (firstNode == null) firstNode = prevNode;
            secondNode = node;
        }
        prevNode = node;
        inOrder(node.right);
    }
}
