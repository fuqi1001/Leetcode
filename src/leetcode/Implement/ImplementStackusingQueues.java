package leetcode.Implement;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 16/9/16.
 */
public class ImplementStackusingQueues {
    class MyStack {
        // Push element x onto stack.

        private Queue queue;

        public void push(int x) {
            Queue q = new LinkedList();     // could be any queue type, see note above
            q.add(x);
            q.add(queue);
            queue = q;
        }

        // Removes the element on top of the stack.
        public void pop() {
            queue.remove();
            queue = (Queue) queue.peek();
        }

        // Get the top element.
        public int top() {
            return (int) queue.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue == null;
        }
    }

}
