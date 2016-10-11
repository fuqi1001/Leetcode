package leetcode;

/**
 * Created by qifu on 16/10/10.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);

        ListNode oddrear = oddHead;
        ListNode evenrear = evenHead;

        ListNode point = head;
        for(int i = 1; point != null; point = point.next,i++){
            if(i % 2 == 1){
                oddrear.next = point;
                oddrear = point;
            }else{
                evenrear.next = point;
                evenrear = point;
            }
        }
        evenrear.next = oddrear.next = null;
        oddrear.next = evenHead.next;
        return oddHead.next;

    }

    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode eHead = head.next;
        ListNode even = eHead;
        while(even !=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = eHead;
        return head;
    }
}
