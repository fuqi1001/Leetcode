package leetcode.other;

public class ReverseNodesinkGroup {
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode move = head;
        int count = 0;
        while(move != null && count != k) {
            move = move.next;
            count++;
        }

        if(count == k) {
            move = reverseKGroup(move, k);
            while(count-- > 0) {
                ListNode next = head.next;
                head.next = move;
                move = head;
                head = next;
            }
            head = move;
        }
        return head;
    }
}
