class Solution {
    public List<Integer> sortArray(int[] nums) {
	quickSort(nums, 0, nums.length - 1);
	List<Integer> res = new ArrayList<>();
	for(int num : nums) {
	    res.add(num);
	}
	return res;
    }
    public void quickSort(int[] nums,int left,int right) {
	if (left >= right) return;
	int pivotIndex = partition(nums, left, right);
	quickSort(nums, left, pivotIndex - 1);
	quickSort(nums, pivotIndex + 1, right);
    }
    public int partition(int[] nums, int left, int right) {
	int pivotIndex = left +(int)Math.random() * (right - left + 1);
	swap(nums, left, pivotIndex);
	int index = left + 1;
	for (int j = left + 1; j <= right; j++) {
	    if (nums[j] < nums[left]) {
		swap(nums, j, index++);
	    }
	}
	swap(nums, left, --index);
	return index;
    }
    public void swap(int[] nums, int a, int b) {
	if (a == b) return;
	int temp = nums[a];
	nums[a] = nums[b];
	nums[b] = temp;
    }
    
}
