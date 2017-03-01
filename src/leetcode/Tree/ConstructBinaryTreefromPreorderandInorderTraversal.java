package leetcode.Tree;
import java.util.HashMap;
/**
 * Created by qifu on 16/10/30.
 */
//https://siddontang.gitbooks.io/leetcode-solution/content/tree/construct_binary_tree.html
public class ConstructBinaryTreefromPreorderandInorderTraversal {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder == null || preorder == null || preorder.length != inorder.length) return null;

            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0 ; i < inorder.length; i++){
                map.put(inorder[i],i);
            }
            return helper(inorder, 0, inorder.length - 1, preorder,0,preorder.length - 1, map);
        }

        private TreeNode helper(int[] inorder,int istart, int inend, int[] preorder, int pstart, int pend, HashMap<Integer,Integer> map){
            if(pstart > pend || istart > inend) return null;

            TreeNode root = new TreeNode(preorder[pstart]);
            int pos = map.get(preorder[pstart]);

            TreeNode leftChild = helper(inorder,istart, pos - 1, preorder, pstart+1,pstart+pos-istart,map);
            TreeNode rightChild = helper(inorder,pos+1,inend,preorder, pos - inend + pend + 1,pend,map);
            /*
            *
            * TreeNode left = helper(inorder, in_start, pos - 1, preorder, p_start + 1, p_start + (pos-in_start), map);
            TreeNode right = helper(inorder, pos + 1, in_end, preorder, p_start + (pos-in_start) + 1, p_end, map);
            *
            *
            * /

             */
            /*
            right child len =>  inend - (pos + 1)
            start from preorder => pend - (inend - (pos + 1)) = pend - inend + pos + 1

            */
            root.left = leftChild;
            root.right = rightChild;

            return root;
        }

}
