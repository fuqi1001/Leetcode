class Solution {
    public int trap(int[] height) {
	int len = height.length;
	int sum = 0;
	int left = 1;
	int right = len - 2;
	int max_left = 0;
	int max_right = 0;
	for (int i = 1; i < len - 1; i++) {
	    if (height[left - 1] < height[right + 1]) {
		max_left = Math.max(max_left, height[left - 1]);
		if (max_left > height[left]) {
		    sum = sum + max_left - height[left];
		}
		left++;
	    } else {
		max_right = Math.max(max_right, height[right + 1]);
		if (max_right > height[right]){
		    sum = sum + max_right - height[right];
		}
		right--;
	    }
	}
	return sum;
    }

}
