package leetcode.other;

/**
 * Created by qifu on 16/10/20.
 */
public class LongestIncreasingSubsequence {

    //O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i = 0 ; i < nums.length ;i++){
            dp[i] = 1;
            for(int j = 0 ; j < i ;j++){
                if(nums[j] < nums[i]){
                    dp[i] = dp[i] > dp[j]+1 ? dp[i] : dp[j] + 1;
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }


    //O(logn)
    //find the first number > num
    private int binarySearch(int[] minLast, int num){
        int start = 0 , end = minLast.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(minLast[mid] < num){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(minLast[start] > num){
            return start;
        }
        return end;
    }

    public int lengthOfLIS(int[] nums){
        int[] minLast = new int[nums.length + 1];
        minLast[0] = -1;
        for(int i = 1 ; i <= nums.length ;i++){
            minLast[i] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i < nums.length; i++){
            int index = binarySearch(minLast,nums[i]);
            minLast[index] = nums[i];
        }
        for(int i = minLast.length - 1 ; i >= 1 ; i--){
            if(minLast[i] != Integer.MAX_VALUE) return i;
        }
        return 0;
    }


}
