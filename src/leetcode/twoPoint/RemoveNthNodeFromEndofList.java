package leetcode.twoPoint;

/**
 * Created by qifu on 16/9/16.
 */

public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        else if(head.next == null && n== 1) return null;

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0 ; i < n - 1; i++){
            if(fast == null) return head;  //n > list.len  can delete;
            fast = fast.next;
        }

        ListNode before = slow;

        while(fast.next != null){
            before = slow;
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.next == null){
            before.next = slow.next;
            return head;
        }

        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rehead = new ListNode(9527);
        rehead.next = head;
        ListNode fast = rehead;
        ListNode slow = rehead;
        while(fast.next != null){
            if(n <= 0){
                slow = slow.next;
            }

            fast = fast.next;
            n--;
        }

        if(slow.next != null){
            slow.next = slow.next.next;
        }
        return rehead.next;
    }
}
