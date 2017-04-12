package leetcode.other;

/**
 * Created by qifu on 17/4/12.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode move = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode pre = dummy;
        while(fast != null) {
            pre = move;
            move = move.next;
            fast = fast.next;
        }
        pre.next = move.next;
        return dummy.next;
    }
}
