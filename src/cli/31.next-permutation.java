class Solution {
    public void nextPermutation(int[] nums) {
	if (nums == null || nums.length <= 1) return;
	int index = nums.length - 2;
	while(index >= 0 && nums[index] >= nums[index + 1]) {
	    index--;
	}
	if (index < 0) {
	    reverse(0, nums);
	    return;
	}
	
	int find = nums.length - 1;
	while(find >= 0 && nums[index] >= nums[find]) {
	    find--;
	}
	swap(index, find, nums);
	reverse(index + 1, nums);	
    }
    private void swap(int left, int right, int[] nums) {
	int temp = nums[left];
	nums[left] = nums[right];
	nums[right] = temp;
    }
    private void reverse(int start, int[] nums) {
	int i = start, j = nums.length - 1;
	while(i < j) {
	    swap(i, j, nums);
	    i++;
	    j--;
	}
    }
}
