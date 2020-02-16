class Solution {
    public int maxSubArray(int[] nums) {
     	int curNum = nums[0];
	int max = curNum;
	for(int i = 1; i < nums.length; i++) {
	    curNum = nums[i] + (curNum > 0 ? curNum : 0);
	    max = Math.max(max, curNum);
	}   
	return max;
    }
}
