package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 16/10/25.
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int dif = 1;
        for(String node: nodes){
            if(--dif < 0) return false;
            if(!node.equals("#")) dif += 2;
        }
        return dif == 0;
    }

//    对于二叉树，我们把空的地方也作为叶子节点（如题目中的#），那么有
//
//    所有的非空节点提供2个出度和1个入度（根除外）
//    所有的空节点但提供0个出度和1个入度
//    我们在遍历的时候，计算diff = outdegree – indegree.
//            当一个节点出现的时候，diff – 1，
//    因为它提供一个入度；当节点不是#的时候，diff+2(提供两个出度) 如果序列式合法的
//    ，那么遍历过程中diff >=0 且最后结果为0.


    //stack
    public boolean isValidSerialization(String preorder){
        Stack<String> stack = new Stack<>();
        String[] nodes = preorder.split(",");
        stack.push("#");
        if(nodes.length == 1 && nodes[0].equals("#"))return true;
        for(String node : nodes){
            if(stack.isEmpty()) return false;
            stack.pop();
            if(!node.equals("#")){
                stack.push("#");
                stack.push("#")
            }
        }
        return stack.isEmpty();
    }
}
