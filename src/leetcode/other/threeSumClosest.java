package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 16/3/30.
 * https://leetcode.com/problems/3sum-closest/
 这道题也是3sum的变体，这里找到的不仅使3sum==target，同时如果没有找到==target的3sum要返回最接近target的值。
 于是，这就需要在使用二分查找法时遍历数组的时候，维护一个最接近target值min，这样当完全遍历完数组扔没找到与target相等的3sum时，可以返回维护的这个min值。
 这道题比3sum和4sum简单的地方就是不需要判断重复问题，因为题目给我们减轻了去重的压力，have exactly one solution。
 即便要求去重，使用之前说过的两个方法：HashSet和挪动指针法，也可以很容易就去重了。
 这里要注意，判断closest的方法是采取target-sum的绝对值与min相比，很容易理解，无论这个closest是在target左还是右，离target最近的就是最closest的。
 */
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        for(int k = 0 ; k <= nums.length - 2 ; k++){
            for(int i = k+1 , j = nums.length - 1; i < j;){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum == target) return target;
                else if (sum > target){
                    if(diff > sum - target){
                        diff = sum - target;
                        closest = sum;
                    }
                    --j;
                }
                else{
                    if( diff > target - sum){
                        diff = target - sum;
                        closest = sum;
                    }
                    ++i;
                }
            }
        }
        return closest;
    }
}
