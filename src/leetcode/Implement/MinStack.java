package leetcode.Implement;

import java.util.Stack;

/**
 * Created by qifu on 16/9/22.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }
    public void pop(){
        if(stack.isEmpty()) return ;
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }


}
