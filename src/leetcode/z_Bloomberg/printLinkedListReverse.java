package leetcode.z_Bloomberg;

public class printLinkedListReverse {
    static Node head = new Node(0);
    static Node cur = head;

    static class Node {
        int data;
        Node next;
        Node(int d) {
            this.data = d;
            next = null;
        }
    }
    public void push(int num) {
        Node new_node = new Node(num);
        cur.next = new_node;
        cur = new_node;
    }
    public void print(Node head) {
        if(head == null) return;
        print(head.next);
        System.out.println(head.data);
    }
    public static void main(String[] args) {
        printLinkedListReverse t = new printLinkedListReverse();
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);
        t.push(5);
        t.push(6);
        t.print(head);

    }
}
