package leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qifu on 17/3/9.
 */
public class NextGreaterElementI {
    // O(m*n)
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        int[] res = new int[findNums.length];

        int temp = 0;
        for(int cur : findNums) {
            int index = map.get(cur) + 1;
            for(; index < nums.length; index++) {
                if(nums[index] > cur) {
                    break;
                }
            }
            res[temp++] = index == nums.length ? -1 : nums[index];
        }
        return res;
    }

    //O(n)
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums) {
            while(!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        return res;
    }
}
