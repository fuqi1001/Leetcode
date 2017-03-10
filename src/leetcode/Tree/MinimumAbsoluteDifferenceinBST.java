package leetcode.Tree;

import java.util.*;

/**
 * Created by qifu on 17/3/10.
 */
public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifference(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);
        Collections.sort(list, new Comparator<TreeNode>() {
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        int len = list.size();
        int min = list.get(1).val - list.get(0).val;
        if(len == 2) return min;

        for(int i = 0; i < len - 1; i++) {
            min = Math.min(min, list.get(i+1).val - list.get(i).val);
        }
        return min;
    }
    public void helper(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }

    //TIME O(n), space O(1);
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return min;
        getMinimumDifference(root.left);
        if(prev != null) {
            min = Math.min(min, Math.abs(root.val - prev.val));
        }
        prev = root;
        getMinimumDifference(root.right);
        return min;
    }
    //time O(nlogn), space o(n)
    TreeSet<Integer> set = new TreeSet<>();
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, Math.abs(root.val - set.floor(root.val)));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, Math.abs(root.val - set.ceiling(root.val)));
            }
        }

        set.add(root.val);

        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }
}
