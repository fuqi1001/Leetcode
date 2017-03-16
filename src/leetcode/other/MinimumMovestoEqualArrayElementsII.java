package leetcode.other;

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
    //
    /*
    Suppose you have two endpoints A and B,
    when you want to find a point C that has minimum sum of distance between AC and BC,
    the point C will always between A and B. Draw a graph and you will understand it.
    Lets keep moving forward. After we locating the point C between A and B,
    we can define that
    dis(AC) = c - a; dis(CB) = b - c;
    sum = dis(AC) + dis(CB) = b - a.
    b - a will be a constant value, given specific b and a.
    Thus there will be no difference between points among A and B.

    In this problem, we set two boundaries, saying i and j,
    and we move the i and j to do the computation.
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while(start < end) {
            count += nums[end] - nums[start];
            start++;
            end--;
        }
        return count;
    }
}
