package leetcode;

/**
 * Created by qifu on 16/10/30.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lefthead = new ListNode(0);
        ListNode righthead = new ListNode(0);

        ListNode left = lefthead;
        ListNode right = righthead;

        while(head != null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            }else{
                right.next = head;
                right = right.next;
            }

            head = head.next;
        }

        right.next = null;
        left.next = righthead.next;
        return lefthead.next;
    }
}
