package leetcode.other;

/**
 * Created by qifu on 16/11/11.
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                int val = head.next.val;
                while(head.next != null && head.next.val == val){
                    head.next = head.next.next;
                }
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
    /*
        用head 当做当前点, 只有当跳过所有重复点(多次重复)的时候 head才移动
        head 只会停在unique 的点上
        dummy(0) -> 3 -> 3 ->4 -> 4 -> 5
        head 不会停在3 和 4 上
        会跳到5上去

     */
}
