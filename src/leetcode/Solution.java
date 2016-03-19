package leetcode; /**
 * Created by qifu on 16/1/27.
 */
import sun.reflect.generics.tree.Tree;
import sun.tools.jstat.Literal;

import java.util.*;
import java.util.regex.Matcher;


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
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result =new int[2];

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < len ;i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            else{
                map.put(target - nums[i] , i);
            }
        }
        return result;

    }
}