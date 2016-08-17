package leetcode;

/**
 * Created by qifu on 16/8/17.
 */
public class InvertBinaryTree {
    //recursive
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }


    //DFS & BFS
    public TreeNode invertTree(TreeNode root){
        if(root == null) return root;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;

            if(temp.left != null){
                stack.push(temp.left);
            }

            if(temp.right != null){
                stack.push(temp.right);
            }
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }

}
