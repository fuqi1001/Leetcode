package leetcode.Implement;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    class DoubleLinkedList {
        int key;
        int val;
        DoubleLinkedList pre;
        DoubleLinkedList post;
    }

    private DoubleLinkedList head, tail;


    /**
     * Always add the new node right after head;
     */

    private void addNode(DoubleLinkedList node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     *  Remove an existing node from the linked list
     */
    private void removeNode(DoubleLinkedList node) {
        DoubleLinkedList pre = node.pre;
        DoubleLinkedList post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     *  Move certain node in between to the head
     */
    private void moveToHead(DoubleLinkedList node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop out current tail
      */
    private DoubleLinkedList popTail() {
        DoubleLinkedList res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Map<Integer, DoubleLinkedList> cache = new HashMap<>();
    int count;
    int capacity;

    public LRU(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DoubleLinkedList();
        head.pre = null;

        tail = new DoubleLinkedList();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLinkedList node = cache.get(key);
        if(node == null) {
            return -1;
        }

        this.moveToHead(node);

        return node.val;
    }

    public void set(int key, int value) {
        DoubleLinkedList node = cache.get(key);
        if(node == null) {
            DoubleLinkedList newNode = new DoubleLinkedList();
            newNode.key = key;
            newNode.val = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity) {
                DoubleLinkedList outTail = this.popTail();
                this.cache.remove(outTail.key);
                --count;
            }
        } else {
            node.val = value;
            this.moveToHead(node);
        }
    }
}