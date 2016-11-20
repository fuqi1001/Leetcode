package leetcode.other;

/**
 * Created by qifu on 16/9/20.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode mid = find(head);
        mid.next = reverse(mid.next);

        ListNode p1 = head;
        ListNode p2 = mid.next;
        while(p1 != null && p2 != null && p1.val == p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;

    }
    private ListNode find(ListNode head){
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
