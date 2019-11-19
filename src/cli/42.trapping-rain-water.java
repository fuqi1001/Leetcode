class Solution {
    public int trap(int[] height) {
	int sum = 0;
	int len = height.length;
	if (len == 0) return sum;
	for(int i = 1; i < len - 1; i++) {
	    int currHeight = height[i];
	    int left_max = height[i - 1];
	    int right_max = height[i + 1];
	    for(int j = i - 1; j >= 0; j--) {
		left_max = Math.max(left_max, height[j]);
	    }
	    for(int j = i + 1; j < len; j++) {
		right_max = Math.max(right_max, height[j]);
	    }

	    int less = Math.min(left_max, right_max);
	    if (less > height[i]) {
		sum = sum + less - height[i];
	    }
	}
	return sum;
    }

}
