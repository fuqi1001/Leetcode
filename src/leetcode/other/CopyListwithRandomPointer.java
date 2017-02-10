package leetcode.other;

/**
 * Created by qifu on 17/2/10.
 */

class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
     };
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode next;

        while(cur != null){
            next = cur.next;
            RandomListNode copyNode = new RandomListNode(cur.label);
            cur.next = copyNode;
            copyNode.next = next;

            cur = next;
        }

        cur = head;

        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;

        RandomListNode copy_head = new RandomListNode(0);
        RandomListNode copy_cur = copy_head;
        RandomListNode copy;

        while(cur != null){
            next = cur.next.next;

            copy = cur.next;
            copy_cur.next = copy;
            copy_cur = copy;

            cur.next = next;
            cur = next;
        }
        return copy_head.next;
    }
}
