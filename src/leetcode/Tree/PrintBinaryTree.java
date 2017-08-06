package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 17/8/6.
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new LinkedList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, columns = (int) (Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for(int i = 0; i < columns; i++) row.add("");
        for(int i = 0; i < rows; i++) res.add(new ArrayList<>(row));
        populateRes(root, res, 0, rows, 0, columns - 1);
        return res;
    }

    private void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if(row == totalRows || root == null) return;
        res.get(row).set((i + j) / 2, Integer.toString(root.val));
        populateRes(root.left, res, row + 1, totalRows, i, (i+j)/2 - 1);
        populateRes(root.right, res, row + 1, totalRows,  (i+j)/2+1, j);
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
