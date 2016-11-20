package leetcode.other;

import java.util.Random;

/**
 * Created by qifu on 16/9/29.
 */
public class LinkedListRandomNode {
    private ListNode head;
    private Random random;


    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int ans = 0;
        ListNode p = head;
        for( int cnt = 1; p != null ; cnt++, p = p.next){
            if(random.nextInt(cnt) == 0) ans = p.val;
        }
        return ans;
    }
}
