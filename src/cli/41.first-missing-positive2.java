class Solution {
    public int firstMissingPositive(int[] nums) {
	int len = nums.length;
	int point = movePoint(nums);
	for (int i = 0; i < point; i++) {
	    int currNum = Math.abs(nums[i]) - 1;
	    if (currNum < point) {
		int num = nums[currNum];
		nums[currNum] = num < 0 ? num : -num;
	    }
	}
	for (int i = 0; i < point; i++) {
	    if (nums[i] > 0) return i + 1;
	}
	return point + 1;
    }

    public int movePoint(int[] nums) {
	int p = 0;
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] > 0) {
		swap(nums, i, p);
		p++;
	    }
	}
	return p;
    }

    private void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
    }
}
