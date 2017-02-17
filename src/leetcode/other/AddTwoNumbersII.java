package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 17/2/2.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode cur = new ListNode(0);

        while((!stack1.isEmpty()) || (!stack2.isEmpty())){
            if(!stack1.isEmpty()){
                sum += stack1.pop().val;
            }
            if(!stack2.isEmpty()){
                sum += stack2.pop().val;
            }
            System.out.println(sum);
            cur.val = sum % 10;
            sum /= 10;
            ListNode head = new ListNode(sum);
            head.next = cur;
            cur = head;
        }
        return cur.val == 0 ? cur.next : cur;
}
