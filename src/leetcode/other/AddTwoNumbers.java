package leetcode.other;

/**
 * Created by qifu on 16/11/21.
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }


}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode newHead = new ListNode(0);
            ListNode cur = new ListNode(0);
            newHead.next = cur;

            int carry = 0;

            while(l1 != null && l2 != null){
                int sum = l1.val + l2.val + carry;
                //System.out.println(sum);
                if(sum / 10 >= 1) {
                    carry = 1;
                }else {
                    carry = 0;
                }
                sum %= 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            while(l1 != null){
                int sum = l1.val + carry;
                if(sum / 10 >= 1){
                    carry = 1;
                } else {
                    carry = 0;
                }
                sum %= 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next;
            }
            while(l2 != null){
                int sum = l2.val + carry;
                if(sum / 10 >= 1){
                    carry = 1;
                }else {
                    carry = 0;
                }
                sum %= 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l2 = l2.next;
            }
            if(carry == 1) cur.next = new ListNode(1);
            return newHead.next.next;

        }
}
