package leetcode.z_Bloomberg_new;

public class NextNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        Node level_start = root;
        while(level_start != null) {
            Node cur = level_start;
            while(cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            level_start = level_start.left;
        }
        return root;
    }

    // not perfect binary tree
    public Node connect2(Node root) {
        Node level_head = null;
        Node prev_move = null;
        Node move = root;

        while(move != null) {

            // current level
            while(move != null) {
                if (move.left != null) {
                    if (prev_move != null) {
                        prev_move.next = move.left;
                    } else {
                        level_head = move.left;
                    }
                    prev_move = move.left;
                }

                if (move.right != null) {
                    if (prev_move != null) {
                        prev_move.next = move.right;
                    } else {
                        level_head = move.right;
                    }
                    prev_move = move.right;
                }
                move = move.next;
            }
            move = level_head;
            level_head = null;
            prev_move = null;
        }
        return root;
    }
}
