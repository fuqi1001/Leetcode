package z_leetcode.bloomberg_onsite;

public class DDL {
    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    Node head;

    public void pushToHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if(head != null) head.prev = newNode;
        head = newNode;
    }

    public void insert(Node node, int data) {
        Node newNode = new Node(data);
        if(node == null) return;

        newNode.next = node.next;
        node.next = newNode;
        newNode.prev = node;

        if(newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        Node last = head;
        if(last == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
        newNode.next = null;
    }

    public void printList() {
        Node last = null;
        System.out.println("forward");
        while(head != null) {
            System.out.print(head.val +" ");
            last = head;
            head = head.next;
        }
        System.out.println();
        System.out.println("back");
        while(last != null) {
            System.out.print(last.val +" ");
            last = last.prev;
        }
    }

    public static void main(String[] args) {
        DDL dl = new DDL();
        dl.append(4);
        dl.append(6);
        dl.append(7);
        dl.append(8);
        dl.insert(dl.head, 5);
        dl.printList();

    }
}
