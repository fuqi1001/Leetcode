package leetcode.other; /**
 * Created by qifu on 16/1/27.
 */
import sun.reflect.generics.tree.Tree;
import sun.tools.jstat.Literal;

import java.util.*;
import java.util.regex.Matcher;
import java.math.BigInteger;



/* public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }*/
public class Solution {
    public static void main(String[] args){
        List<Integer> res = new ArrayList<>();
        for(int i = 1000 ; i <= 2000 ;i++){
            helper(res,i);
        }

    }
    public static void helper(List<Integer> res,int num){
        int g = num%10;
        num /= 10;
        int s = num%10;
        num /= 10;
        int b = num%10;
        int q = num / 10;
        System.out.println(g+" "+s+" "+b+" "+q);
    }
}