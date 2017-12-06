package z_leetcode.bloomberg_onsite;

import java.util.Arrays;
import java.util.Stack;

public class ClosestZeroes {
    public static int[] doSomething(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                stack.push(i);
            }
        }
        int start = stack.pop();

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 0) {
                result[i] = 0;
                start = i;
            } else {
                System.out.println(start+" " + i);
                if(!stack.isEmpty() && Math.abs(start - i) > Math.abs(stack.peek() - i) ) {
                    start = stack.pop();
                }
                result[i] = Math.abs(start - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = doSomething(new int[]{1,1,0,0,0,1,1,1});
        for(int num : res){
            System.out.print(num +" ");
        }
    }
}
