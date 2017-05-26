package leetcode.other;

/**
 * Created by qifu on 16/11/19.
 */
public class SortList {

    //merge sort
    /*
    每次递归都找中点然后分左右两个部分分别处理子部分
    然后把字部分合并到一起,较小的append到当前list上然后移动指针
    直到左或右部分为空,再把剩下的部分append到list上
     */
    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode middle = findMid(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null) {
            if(left.val > right.val) {
                tail.next = right;
                right = right.next;
            } else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }
        if(left!= null) {
            tail.next = left;
        } else {
            tail.next = right;
        }
        return dummy.next;
    }
}
