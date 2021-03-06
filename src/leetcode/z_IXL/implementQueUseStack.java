package leetcode.z_IXL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by qifu on 17/4/22.
 */
public class implementQueUseStack {
    Stack<Integer> input;
    Stack<Integer> output;

    public implementQueUseStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }
    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if(output.isEmpty()) {
            while(!input.isEmpty())  {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    /*
    I have one input stack, for pushing incoming elements,
    and using one output stack, from which I peek/pop
    I move the elements from input stack to output stack when needed
    when I need to peek or pop but the output stack is empty,
    I will move all elements from input to output stack, thereby reversing the order
    so that will be correct order for peek/pop function for a queue

    The loop in peek does the moving from input to output stack.
    Each element only ever gets moved like that once, though, and only after we already
    spent time pushing it, so overall amortized cose for each operation is O(1)


     */

    //用queue实现stack
    private Queue queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue q = new LinkedList<>();
        q.add(x);
        q.add(queue);
        queue = q;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int cur = (int) queue.poll();
        queue = (Queue) queue.peek();
        return cur;
    }

    /** Get the top element. */
    public int top() {
        return (int)queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
