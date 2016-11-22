package leetcode.other;

/**
 * Created by qifu on 16/11/21.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode dummy = new ListNode(0);
        newHead.next = dummy;
        int temp = 0;
        while(l1 != null && l2 != null){
            if(l1.val + l2.val + temp>= 10){
                l1.val = (l1.val + l2.val + temp) % 10;
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
                l2 = l2.next;
                temp = 1;
            }else{
                l1.val = (l1.val + l2.val + temp) % 10;
                dummy.next = l1;
                if(l1.val >= 10){
                    temp = 1;
                }
                else {
                    temp = 0;
                }
                dummy = dummy.next;
                l1 = l1.next;
                l2 = l2.next;

            }
        }
        while(l1 != null){
            if(temp == 1){
                l1.val =  l1.val + temp;
                if(l1.val < 10) temp = 0;
                l1.val = l1.val % 10;
                dummy.next = l1 ;
                dummy = dummy.next;
                l1 = l1.next;

            }else{
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
        }
        while(l2 != null){
            if(temp == 1){
                l2.val =  (l2.val + temp) ;
                if(l2.val < 10) temp = 0;
                l2.val =l2.val % 10;
                dummy.next = l2 ;

                dummy = dummy.next;
                l2 = l2.next;

            }else{
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if(temp == 1){
            dummy.next = new ListNode(1);
        }

        return newHead.next.next;
    }
}
