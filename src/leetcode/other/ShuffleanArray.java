package leetcode.other;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qifu on 16/9/29.
 */
public class ShuffleanArray {
    private  int[] nums= null;
    private Random random = null;

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        random = new Random(System.currentTimeMillis());
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(nums,nums.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ans = Arrays.copyOf(nums,nums.length);
        for(int i = 1; i < nums.length ;i++){
            int swapIndex = random.nextInt(i+1);
            swap(ans,i,swapIndex);
        }
        return ans;
    }

    private void swap(int[] ans,int from, int to){
        int temp = ans[from];
        ans[from] = ans[to];
        ans[to] = temp;
    }
}
