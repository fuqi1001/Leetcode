package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/3/23.
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int zero = 0;
        int k = 1;
        for(int left = 0, right = 0; right < nums.length; right++){
            if(nums[right] == 0)
                zero++;
            while(zero > k) {
                if(nums[left++] == 0) {
                    zero--;
                }
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }

    // follow up , 数组无限长 , 用queue来存0的位置
    public int findMaxConsecutiveOnes(int[] nums) {
        Queue<Integer> zero_index = new LinkedList<>();
        int count = 0, k = 1;
        for(int left = 0, right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zero_index.add(right);
            }
            if(zero_index.size() > k){
                left = zero_index.poll() + 1;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }

    //存0 的index, 因为k = 1;

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, index = -1;
        for(int left = 0, right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                left = index + 1;
                index = right;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
