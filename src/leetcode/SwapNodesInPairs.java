package leetcode;

/**
 * Created by qifu on 16/9/7.
 */
public class SwapNodesInPairs {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;

        while(cur.next != null && cur.next.next != null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;

            cur = cur.next.next;


        }
        return newHead.next;

    }
}
