package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/3/18.
 */
public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        List<TreeNode> list = new ArrayList<>();
        getT(root, list);
        int[] nums = new int[list.size()];
        int index = 0;
        for(TreeNode cur : list) {
            nums[index++] = cur.val;
        }
        //Arrays.sort(nums);
        plus(root, nums);
        return root;

    }
    public void getT(TreeNode node, List<TreeNode> list) {
        if(node == null) return;
        list.add(node);
        getT(node.left, list);
        getT(node.right, list);
    }
    public void plus(TreeNode node, int[] nums) {
        if(node == null) return;
        int sum = 0;
        for(int num : nums) {
            if(num > node.val) {
                sum += num;
            }
        }
        node.val += sum;
        plus(node.left, nums);
        plus(node.right, nums);
    }
}
