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
}
