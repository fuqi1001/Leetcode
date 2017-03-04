package leetcode.Tree;

import java.util.*;

/**
 * Created by qifu on 17/3/4.
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return (List<Integer>)res;
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(res.size() < k) {
                res.add(node.val);
            } else {
                int first = res.peek();
                if(Math.abs(first - target) > Math.abs(node.val - target)) {
                    res.poll();
                    res.add(node.val);
                } else {
                    break;
                }
            }

            if(node.right != null) {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return (List<Integer>) res;
    }

    // two stack
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> pre = new Stack<>();
        Stack<TreeNode> suc = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val <= target) {
                pre.push(cur);
                cur = cur.right;
            } else {
                suc.push(cur);
                cur = cur.left;
            }
        }
        List<Integer> res = new ArrayList<>();

        while(k-- > 0) {
            if(pre.empty() && suc.empty()) {
                break;
            } else if(pre.empty()) {
                res.add(getSuc(suc));
            } else if(suc.empty()) {
                res.add(getPre(pre));
            } else if(Math.abs(suc.peek().val - target) < Math.abs(pre.peek().val - target)) {
                res.add(getSuc(suc));
            } else {
                res.add(getPre(pre));
            }
        }
        return res;
    }

    private int getPre(Stack<TreeNode> pre) {
        TreeNode cur = pre.pop();
        TreeNode next = cur.left;
        while(next != null) {
            pre.push(next);
            next = next.right;
        }
        return cur.val;
    }

    private int getSuc(Stack<TreeNode> suc) {
        TreeNode cur = suc.pop();
        TreeNode next = cur.right;
        while(next != null) {
            suc.push(next);
            next = next.left;
        }
        return cur.val;
    }

    //
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> pre = new Stack<>();
        Stack<TreeNode> suc = new Stack<>();
        boolean reverse = false;
        inorder(root, target, reverse, pre);
        inorder(root, target, !reverse, suc);

        while(k-- > 0) {
            if(pre.isEmpty()) {
                res.add(suc.pop().val);
            } else if(suc.isEmpty()) {
                res.add(pre.pop().val);
            } else if(Math.abs(pre.peek().val - target) < Math.abs(suc.peek().val - target)){
                res.add(pre.pop().val);
            } else {
                res.add(suc.pop().val);
            }
        }

        return res;
    }

    public void inorder(TreeNode root, double target, boolean reverse, Stack<TreeNode> stack) {
        if(root == null) {
            return;
        }

        inorder(reverse ? root.right : root.left, target, reverse, stack);
        if((reverse && root.val <= target) || (!reverse && root.val > target)) return;
        stack.push(root);
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }

}
