package leetcode.other;

/**
 * Created by qifu on 17/2/14.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;

        while(preCurrent.next != null) {
            ListNode cur = preCurrent.next;
            preCurrent.next = cur.next;
            cur.next = preMiddle.next;
            preMiddle.next = cur;
        }

        ListNode p1 = head;
        ListNode p2 = preMiddle.next;
        while(p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    //other way to reverse after mid portion
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;
        ListNode pre = null;
        ListNode cur = mid.next;
        mid.next = null;
        int count = 0;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            count++;
        }
        mid.next = pre;

        ListNode p1 = head;
        ListNode p2 = mid.next;
        while(p1 != mid) {
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
    }
}
