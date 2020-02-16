/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode prev = dummy;
	ListTail tail = null;
	if (k == 0) return dummy.next;
	while(k >= 0) {
	    prev = head;
	    if (head.next == null) {
		tail = head;
		head = dummy.next;	
	    } else {
	    	head = head.next;
	    }
	    k--; 
	}

	        
    }
}
