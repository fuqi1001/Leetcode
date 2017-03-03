package leetcode.Tree;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/3/3.
 */
public class SerializeAndDeserializeBST {
    private String splitter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }
    //preorder
    private void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val).append(splitter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(splitter);
        if(data.length() == 0) return null;
        int[] pos = new int[1];
        pos[0] = 0;
        return buildTree(nodes, pos, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(String[] nodes, int[] pos, int min, int max) {
        if(pos[0] == nodes.length) return null;
        int val = Integer.valueOf(nodes[pos[0]]);
        if(val < min || val > max) return null;

        TreeNode cur = new TreeNode(val);
        pos[0]++;
        cur.left = buildTree(nodes, pos, min, val);
        cur.right = buildTree(nodes, pos, val, max);
        return cur;
    }
    //=============
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "{}";
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for(int i = 0; i < queue.size(); i++){
            TreeNode cur = queue.get(i);
            if(cur == null) continue;
            queue.add(cur.left);
            queue.add(cur.right);
        }

        while(queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for(int i = 1; i < queue.size(); i++){
            if(queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("{}")) return null;
        data = data.substring(1, data.length() - 1);
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for(int i = 1; i < nodes.length; i++){
            if(!nodes[i].equals("#")) {
                TreeNode cur_node = new TreeNode(Integer.valueOf(nodes[i]));
                if(isLeft) {
                    queue.get(index).left = cur_node;
                } else {
                    queue.get(index).right = cur_node;
                }
                queue.add(cur_node);
            }
            if(!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}
