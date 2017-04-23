package leetcode.z_IXL;


import leetcode.Tree.ListNode;

/**
 * Created by qifu on 17/4/22.
 */
public class kthElementFromListEnd {

    //O(n)
    public int find(ListNode root, int k) {
        int len = 0;
        ListNode temp = root;
        while(temp != null) {
            temp = temp.next;
            len++;
        }

        if(len < k) return;

        temp = root;
        for(int i = 1;i < len - k + 1; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    //O(n) two point

    public int find(ListNode root, int k) {
        ListNode fast = root;
        ListNode slow = root;
        int count = 0;
        if(root != null) {
            while(count < k) {
                if(fast == null) {
                    return -1; //cant find two short
                }
                fast = fast.next;
                count++;
            }
            while(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.val;
        }
        return -1;
    }
}
