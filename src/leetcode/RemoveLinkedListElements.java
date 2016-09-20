package leetcode;

/**
 * Created by qifu on 16/9/20.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head ==null) return null;
        while(head != null && head.val == val){
            head = head.next;
        }

        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }
            else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        while(head.next != null ){
            if(head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return newHead.next;
    }
}
