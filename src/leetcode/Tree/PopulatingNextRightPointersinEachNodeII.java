package leetcode.Tree;

/**
 * Created by qifu on 17/2/6.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) return;

        TreeLinkNode cur = root;
        TreeLinkNode head = null;
        TreeLinkNode prev = null;

        while(cur != null ){
            while(cur != null) {    // for current level

                if(cur.left != null){       // for left child
                    if(prev != null){
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }


                if(cur.right != null) {
                     if(prev != null) {
                         prev.next = cur.right;
                     } else {
                         head = cur.right;
                     }
                     prev = cur.right;
                }
                cur = cur.next;
            } // level over;
                                /// start next level
            cur = head;
            head = null;
            prev = null;
        }
    }


    ////
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode prev = dummyHead;
        while(root != null){
            if(root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if(root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;
            if(root == null){
                root = dummyHead.next;
                prev = dummyHead;
                dummyHead.next = null;
            }
        }
    }
}
