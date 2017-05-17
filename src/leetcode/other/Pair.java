package leetcode.other;

import java.util.Stack;

class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for(int cur : nums) {
            if(stack.isEmpty() || stack.peek().min > cur) stack.push(new Pair(cur, cur));
            else if(cur > stack.peek().min){
                Pair last = stack.pop();
                if(cur < last.max) return true;
                else {
                    last.max = cur;
                    while(!stack.isEmpty() && stack.peek().max <= cur) stack.pop();
                    if(!stack.isEmpty() && stack.peek().min < cur) return true;
                    stack.push(last);
                }
            }
        }
        return false;
    }