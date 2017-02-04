package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/2/4.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges){
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        for(int i = 0 ; i < edges.length; i++){
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            if(x == y) return false; //cycle

            nums[x] = y;
        }
        return edges.length == n-1;
    }

    private int find(int[] nums, int i){
        if(nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
