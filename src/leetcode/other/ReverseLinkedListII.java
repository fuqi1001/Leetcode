package leetcode.other;

/**
 * Created by qifu on 16/11/8.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null || m >= n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for(int i = 1 ; i < m ;i++){
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode new_head = null;

        for(int i = 0 ; i <= n - m ;i++){
            ListNode temp = cur.next;
            cur.next = new_head;
            new_head = cur;
            cur = temp;
        }

        pre.next.next = cur;
        pre.next = new_head;
        return dummy.next;
        /*
        翻转, 不是in place 交换,
        箭头反向
         */
    }
}
