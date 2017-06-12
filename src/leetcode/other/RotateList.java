package leetcode.other;

/**
 * Created by qifu on 17/2/14.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int len = 0;

        while(fast.next != null){
            fast = fast.next;
            len++;
        }

        int i = len - k % len;

        while(i > 0){
            slow = slow.next;
            i--;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
    /*
    题目要求right by k place
    从右边起计算, 所以 i = len - k % len
     */
}
