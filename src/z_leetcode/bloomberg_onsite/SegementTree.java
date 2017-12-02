package z_leetcode.bloomberg_onsite;

public class SegementTree {
    class Node {
        int left, right;
        boolean cover;
        int count;
        Node leftChild;
        Node rightChild;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
            cover = false;
            count = 0;
        }
    }
    Node root;

    /**
     * public api
     * build a segment tree
     */
    public void build(int left, int right) {
        root = new Node(left, right);
        build(root);
    }

    /**
     * private api
     * build a segment tree
     */
    private void build(Node root) {
        int left = root.left;
        int right = root.right;

        //root is the leave node
        if(right - left == 1) {
            return;
        } else if(right - left > 1) {
            int mid = (left + right) >> 1;
            Node leftNode = new Node(left, mid);
            Node rightNode = new Node(mid, right);
            root.leftChild = leftNode;
            root.rightChild = rightNode;

            //build left & right child tree
            build(leftNode);
            build(rightNode);
        }
    }

    /**
     * insert a segment [c, d] public api
     * c is left
     * d is right
     * root is the root node
     */
    public void insert(int c, int d) {
        insert(c, d, root);
    }

    /**
     * private api for insert
     */
    private void insert(int c, int d, Node node) {
        if(node == null || c < node.left || d > node.right) {
            System.out.println("invalid input: " +"c: "+c+" d: "+d);
            System.out.println("root: " + node.left+" "+node.right);
            return;
        }
        if(node.left == c && node.right == d) {
            node.count++;
            node.cover = true;
            return;
        }

        int mid = (node.left + node.right) >> 1;
        if(d <= mid) {
            insert(c, d, node.leftChild);
        } else if(c >= mid) {
            insert(c, d, node.rightChild);
        } else {
            insert(c, mid, node.leftChild);
            insert(mid, d, node.rightChild);
        }
    }


    /**
     * delete a segment
     * public
     */
    public void delete(int c, int d) {
        delete(c, d, root);
    }

    /**
     * delete a segment
     * private
     */
    private void delete(int c, int d, Node node) {
        if(node == null || c < node.left || d > node.right) {
            System.out.println("invalid input");
            return;
        }
        if(c == node.left && d == node.right) {
            node.count--;
            if(node.count == 0) node.cover = false;
            return;
        }
        int mid = (node.left + node.right) >> 1;
        if(d <= mid) {
            delete(c, d, node.leftChild);
        } else if(c >= mid) {
            delete(c, d, node.rightChild);
        } else {
            delete(c, mid, node.leftChild);
            delete(mid, d, node.rightChild);
        }
    }

    /**
     * preorder
     */

    public void preOrder() {
        preOrder(root);
    }

    /**
     * preorder
     * private
     */

    private void preOrder(Node root) {
        if(root.right - root.left == 1) {
            System.out.println("[" + root.left + ", " + root.right + "]: " + root.count);
            return;
        } else if(root.right - root.left > 1) {
            System.out.println("["+root.left+", " + root.right +"]: "+ root.count);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }

    }


    /**
     * cover is true count;
     * public
     * @return
     */
    public int Count() {
        return Count(root);
    }

    /**
     * cover is true
     * private
     */
    public int Count(Node node) {
        if(node.cover == true) return node.right - node.left;
        else {
            if(node.right - node.left == 1) return 0;
            else return Count(node.leftChild) + Count(node.rightChild);
        }
    }

    public static void main(String[] args) {
        SegementTree segmentTree = new SegementTree();
        segmentTree.build(1,10);
        segmentTree.insert(3,5);
        segmentTree.insert(3,5);
        segmentTree.insert(2,5);
        segmentTree.insert(3,9);
        segmentTree.insert(1,10);
        //[2,5]被分为[2,3],[3,5]
//[3,9]被分为[3,5],[5,9]
//[5,9]被分为[5,7],[7,8]+[8,9]
        System.out.println("前序遍历线段树:");
        segmentTree.preOrder();

        System.out.println("删除线段:");
        segmentTree.delete(1,10);
        segmentTree.delete(3,5);

        System.out.println("前序遍历线段树:");
        segmentTree.preOrder();

        System.out.println("被覆盖的长度:"+segmentTree.Count());
//        输出为[2,3]+[3,5]+[5,7]+[7,8]+[8,9]=7

    }
}