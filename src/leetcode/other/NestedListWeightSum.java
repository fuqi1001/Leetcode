package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 16/11/30.
 */
public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    public int helper(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger nest : nestedList){
            if(nest.isInteger()){
                sum += nest.getInteger() * depth;
            }
            else{
                sum += helper(nest.getList(), depth + 1);
            }
        }
        return sum;
    }

    ///
    public int depthSum(List<NestedInteger> nestedList) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(nestedList, 1));
        int sum = 0;
        while(!stack.isEmpty()){
            Pair top = stack.pop();
            for(NestedInteger nest : top.nestedList){
                if(nest.isInteger()){
                    sum += (top.depth * nest.getInteger());
                }else{
                    stack.push(new Pair(nest.getList(), top.depth + 1));
                }
            }
        }
        return sum;
    }
    private static class Pair{
        List<NestedInteger> nestedList;
        int depth;
        public Pair(List<NestedInteger> nestedList, int depth){
            this.nestedList = nestedList;
            this.depth = depth;
        }
    }
}
