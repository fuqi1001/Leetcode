class Solution {
    public int trap(int[] height) {
	int sum = 0;
	int len = height.length;
	if (len == 0) return sum;
	int[] max_left = new int[len];
	int[] max_right = new int[len];
	for(int i = 1; i < len - 1; i++) {
	    max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
	}
	for(int i = len - 2; i >= 0; i--) {
	    max_right[i] = Math.max(max_right[i+1], height[i+1]);
	}
	for(int i = 1; i < len - 1; i++) {
	    int cur = height[i];
	    int less = Math.min(max_left[i], max_right[i]);
	    if (less > cur) {
		sum = sum + less - cur;
	    }
	    
	}
	return sum;
    }

}
