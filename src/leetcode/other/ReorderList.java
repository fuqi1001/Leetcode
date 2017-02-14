package leetcode.other;

/**
 * Created by qifu on 17/2/14.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode p1 = head;
        ListNode p2 = head;

        //find the mid;
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // reverse mid -> end

        ListNode preMid = p1;
        ListNode preCur = preMid.next;
        while(preCur.next != null){
            ListNode cur = preCur.next;
            preCur.next = cur.next;
            cur.next = preMid.next;
            preMid.next = cur;
        }

        p1 = head;
        p2 = preMid.next;
        while(p1 != preMid){
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }
}
