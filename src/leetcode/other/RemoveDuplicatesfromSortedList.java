package leetcode.other;

/**
 * Created by qifu on 16/8/30.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode H = head;
        while(head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return H;
    }
}
