package leetcode.other;

public class SplitLinkedListinParts {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        for(ListNode x = root ; x != null ; x = x.next, len++);
        int div1 = len / k + 1, count1 = len % k;
        int div2 = len / k, count2 = k - len % k;
        ListNode[] res = new ListNode[k];
        ListNode prev = null;
        for(int i = 0; i < count1; i++) {
            res[i] = root;
            for(int j = 0; j < div1; j++) {
                prev = root;
                root = root.next;
            }
            if(prev != null) prev.next = null;
        }

        for(int i = count1; i < k; i++) {
            res[i] = root;
            for(int j = 0; j < div2; j++) {
                prev = root;
                root = root.next;
            }
            if(prev != null) prev.next = null;
        }
        return res;
    }
}
