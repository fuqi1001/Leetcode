package leetcode.other;

/**
 * Created by qifu on 16/8/30.
 */

//iterative solution
public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        while(head != null){
            ListNode cur = head.next;
            head.next = prev;
            prev = head;
            head = cur;

        }
        return prev;
    }

    //recursive solution
    public ListNode reverseList(ListNode head){
        return reverseListInt(head,null);
    }

    public ListNode reverseListInt(ListNode head,ListNode newHead){
        if(head == null)
            return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next,head);
    }
}
