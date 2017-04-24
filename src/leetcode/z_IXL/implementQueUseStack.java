package leetcode.z_IXL;

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
}
