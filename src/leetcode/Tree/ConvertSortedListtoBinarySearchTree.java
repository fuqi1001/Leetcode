package leetcode.Tree;

/**
 * Created by qifu on 16/10/27.
 */

public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

public class ConvertSortedListtoBinarySearchTree {
    ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        h = head;
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        return helper(0, len - 1);
    }
    private TreeNode helper(int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        root.left = left;
        h = h.next;
        TreeNode right = helper(mid + 1, end);
        root.right = right;
        return root;
    }
}
