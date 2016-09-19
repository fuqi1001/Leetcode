package leetcode;

/**
 * Created by qifu on 16/9/19.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==null || headB == null) return null;

        int lenA = helper(headA);
        int lenB = helper(headB);

        int num = Math.abs(lenA - lenB);

        if(lenA > lenB){
            while(num > 0){
                headA = headA.next;
                num --;
            }
        }
        else{
            while(num > 0){
                headB = headB.next;
                num --;
            }
        }
        while(headA != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public int helper(ListNode head){
        int count = 0;
        while(head.next!=null){
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        ListNode tailA = null;
        ListNode tailB = null;

        while(true){
            if(pA == null){
                pA = headB;
            }

            if(pB == null){
                pB = headA;
            }

            if(pB.next == null){
                tailB = pB;
            }
            if(pA.next == null){
                tailA = pA;
            }

            if(tailB != null && tailA != null && tailA != tailB) return null;
            if(pA == pB) return pA;
            pA = pA.next;
            pB = pB.next;
        }
    }

    /*
    两种方法其实是一样的
    方法一手动调整现行步数 遍历完得到长度 长的那个链表先走 lenA-lenB步;

    方法二同时走 短的走到末尾又跳到另一个链表的头开始走 相差的步数
    等长的走完 跳到短的的时候  两条链表剩下的长度是一样的.


     */
}
