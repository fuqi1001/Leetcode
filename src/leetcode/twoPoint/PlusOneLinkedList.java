package leetcode.twoPoint;

/**
 * Created by qifu on 17/1/7.
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while(j.next != null){
            j = j.next;
            if(j.val != 9){
                i = j;
            }
        }

        if(j.val != 9){
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while(i != null){
                i.val = 0;
                i = i.next;
            }
        }
        if(dummy.val == 0) return dummy.next;
        else return dummy;
    }
}
