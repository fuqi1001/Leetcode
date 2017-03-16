package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 17/3/16.
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> res = new Stack<>();
        int carry = 1;
        while(head != null) {

            stack1.push(head);
            head = head.next;
        }

        while(!stack1.isEmpty()) {
            ListNode cur = stack1.pop();
            int sum = cur.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            res.push(cur);
        }
        if(carry == 1) res.push(new ListNode(1));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!res.isEmpty()){
            cur.next = res.pop();
            cur = cur.next;
        }
        return dummy.next;
    }

    //O(n) time O(1) space
    /*
    set two point
    ListNode `move` keep move to end of the List;
    ListNode `stop` stop by the last node which val is not `9`
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode move = dummy;
        ListNode stop = dummy;
        while(move.next != null) {
            move = move.next;
            if(move.val != 9) {
                stop = move;
            }
        }

        if(move.val != 9) {
            move.val += 1;
        } else {
            stop.val += 1;
            stop = stop.next;
            while(stop != null) {
                stop.val = 0;
                stop = stop.next;
            }
        }
        if(dummy.val == 0) return dummy.next;
        else return dummy;
    }

    //
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        return dummy.val == 0 ? dummy.next : dummy;
    }
    private int helper(ListNode head) {
        if(head == null) return 1;
        head.val += helper(head.next);
        if(head.val <= 9) return 0;
        head.val %= 10;
        return 1;
    }

}
