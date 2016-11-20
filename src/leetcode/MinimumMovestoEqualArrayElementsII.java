package leetcode;

import java.util.Arrays;

/**
 * Created by qifu on 16/11/20.
 Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

 You may assume the array's length is at most 10,000.
 Input:
 [1,2,3]

 Output:
 2

 Explanation:
 Only two moves are needed (remember each move increments or decrements one element):

 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            res[i] = 0;
            for(int j = 0 ; j < nums.length ; j++){
                res[i] += Math.abs(nums[i] - nums[j]);
                if(res[i] < 0){
                    res[i] = Integer.MAX_VALUE;
                    break;
                }
            }

            //System.out.println(res[i]);
        }
        Arrays.sort(res);
        return res[0];
    }
}
