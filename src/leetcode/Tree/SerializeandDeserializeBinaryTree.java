package leetcode.Tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    String spliter = ",";
    String nullNode = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(nullNode).append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        String[] str = data.split(spliter);
        nodes.addAll(Arrays.asList(str));
        return buildTree(nodes);
    }

    public TreeNode buildTree(Queue<String> que) {
        String val = que.poll();
        if(val.equals(nullNode)) return null;
        else {
            TreeNode cur = new TreeNode(Integer.valueOf(val));
            cur.left = buildTree(que);
            cur.right = buildTree(que);
            return cur;
        }
    }
}
