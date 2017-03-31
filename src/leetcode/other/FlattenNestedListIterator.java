package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 17/3/31.
 */
public class FlattenNestedListIterator {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        helper(nestedList);
    }
    private void helper(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0 ; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            if(stack.peek().isInteger()) return true;
            helper(stack.pop().getList());
        }
        return false;
    }
}
