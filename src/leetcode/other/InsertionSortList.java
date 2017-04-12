package leetcode.other;

/**
 * Created by qifu on 16/10/29.
 */
public class InsertionSortList {
    //40ms
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0);

        while(head != null){
            ListNode node = newHead;

            while(node.next != null && node.next.val < head.val){
                node = node.next;
            }

            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return newHead.next;
    }
    // 8ms
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode move = head;
        dummy.next = head;
        ListNode point = dummy;

        while(move != null ){
            if(move.next != null && move.val > move.next.val) {
                ListNode cur = move.next;
                point = dummy;
                while(point.next != null && point.next.val < cur.val) {
                    point = point.next;
                }
                ListNode temp = cur.next;
                cur.next = point.next;
                point.next = cur;
                move.next = temp;
            } else {
                move = move.next;
            }
        }
        return dummy.next;
    }
    /*
    如果碰到是递增顺序的暂时先不管,开始往下扫

     */
}
