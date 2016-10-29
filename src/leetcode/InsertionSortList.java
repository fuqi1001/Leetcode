package leetcode;

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
        if(head == null) return null;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode tail = head;
        ListNode cur = null;
        ListNode point = head;

        while(tail.next != null){
            if(tail.val > tail.next.val){
                cur = tail.next;
                point = newHead;
                while(point.next.val <= cur.val){
                    point = point.next;
                }

                ListNode temp = cur.next;
                cur.next = point.next;
                point.next = cur;
                tail.next =temp;
            }else{
                tail = tail.next;
            }
        }
        return newHead.next;
    }
}
