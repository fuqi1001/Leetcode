package leetcode.z_IXL;

import leetcode.Tree.ListNode;

/**
 * Created by qifu on 17/4/23.
 */
public class loopLinkedList {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(slow == fast) return true;
        }
        return false;
    }

    /*
    For this problem, we just need to use the floyd judge circle algorithm
    we use two move point,
    one fast point every time move two step
    one slow point every time move one step
    use a while loop let them move together as their own rule
    if fast point next node is null, mean there is no circle, reach the end of the list
    but, if the fast and slow point meet in the loop,
    thats mean there must be a circle in the list

     */
}
