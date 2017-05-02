package leetcode.other;

/**
 * Created by qifu on 16/11/11.
 */
public class MinimumSizeSubarraySum {

    //O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        while(right < len) {
            sum += nums[right++];
            while(sum >= s) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //O(nlogn)
    /*
    当不能对数组进行排序, 又需要logn的算法时
    课考虑进行binary search
    因为都是正数,对原数组累加就会得到一个排好序的递增数组
    可进行binary search
     */
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < sum.length; i++) {
            int end = binarySearch(i + 1, sum.length - 1, sum[i] + s, sum);
            if(end == sum.length) break;
            if(end - i < res) {
                res = end - i;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public int binarySearch(int left, int right, int target, int[] sum) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sum[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
