package leetcode.other;

/**
 * Created by qifu on 17/3/13.
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
