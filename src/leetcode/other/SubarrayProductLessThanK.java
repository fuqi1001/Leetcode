package leetcode.other;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k < 2) return 0;
        int result = 0;
        int prod = 1;
        for(int i = 0, move = 0; move < nums.length; move++){
            prod *= nums[move];
            while(i < nums.length && prod >= k){
                prod /= nums[i++];
            }
            result += move - i + 1;
        }
        return result;
    }
}
