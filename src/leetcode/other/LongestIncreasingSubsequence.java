package leetcode.other;

/**
 * Created by qifu on 16/10/20.
 */
public class LongestIncreasingSubsequence {

    //O(n^2)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        for(int i = 0; i < len; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }


    //O(logn)
    //find the first number > num
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;
        for(int num : nums) {
            int i = 0, j = size;
            while(i != j) {
                int mid = i + (j - i) / 2;
                if(tail[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tail[i] = num;
            if(i == size) size++;
        }
        return size;
    }
    //O(logn)
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int size = 0;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < tails[0]) {
                tails[0] = nums[i];
            } else if(nums[i] > tails[size]) {
                tails[++size] = nums[i];
            } else {
                tails[bs(tails, 0, size, nums[i])] = nums[i];
            }
        }
        return size + 1;
    }
    public int bs(int[] tails, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(tails[mid] == target) {
                return mid;
            }
            if(tails[mid] < target) {
                left = mid + 1;
            }
            if(tails[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

}
