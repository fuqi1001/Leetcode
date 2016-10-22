package leetcode.Tree;

/**
 * Created by qifu on 16/10/21.
 */
class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
}
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if(root==null) return ;

        if(root.left != null){
            root.left.next = root.right;
        }

        if(root.right != null){
            root.right.next = root.next == null ? null : root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }


    //-------
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode parent = root;
        TreeLinkNode next = parent.left;
        while(parent != null && next != null){
            TreeLinkNode pre = null;
            while(parent != null){
                if(pre == null){
                    pre = parent.left;
                }else{
                    pre.next = parent.left;
                    pre = pre.next;
                }
                pre.next = parent.right;
                pre = pre.next;
                parent = parent.next;
            }
            parent = next;
            next = parent.left;
        }
    }
}
