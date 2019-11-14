class Solution {
    public int[] searchRange(int[] nums, int target) {
	int index = Arrays.binarySearch(nums, target);
	if (index < 0) return new int[]{-1, -1};
	int left = index, right = index;
	while(left >= 0) {
	    if (nums[left] == target) {
		left--;
	    } else {
		break;
	    }
	}
	while(right < nums.length) {
	    if (nums[right] == target) {
		right++;
	    } else break;
	}
	return new int[]{left+1, right-1};
    }
}
