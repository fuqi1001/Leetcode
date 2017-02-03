package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 17/2/3.
 */
public class VerifyPreorderSequenceinBinarySearchTree {

    ///https://segmentfault.com/a/1190000003874375

    public boolean verifyPreorder(int[] preorder){
        int index = -1;
        int min = Integer.MIN_VALUE;
        for(int cur : preorder){
            if(cur < min) return false;

            while(index >= 0 && cur > preorder[index]){
                min = preorder[index--];
            }
            preorder[++index] = cur;
        }
        return true;
    }

    ///
    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int cur : preorder){
            if(cur < min) return false;

            while((!stack.isEmpty()) && cur > stack.peek() ){
                min = stack.pop();
            }
            stack.push(cur);
        }
        return true;
    }
}
