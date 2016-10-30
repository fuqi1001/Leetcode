package leetcode;

/**
 * Created by qifu on 16/10/30.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null||head.next == null ) return null;

        while(true){
            if(fast == null || fast.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
