package leetcode.other;

public class TrapRainWater {
    public int trap(int[] height) {
        int a = 0, b = height.length - 1;
        int res = 0;
        int left = 0;
        int right = 0;
        while(a <= b) {
            left = Math.max(left, height[a]);
            right = Math.max(right, height[b]);
            if(left < right) {
                res += (left - height[a]);
                a++;
            } else {
                res += (right - height[b]);
                b--;
            }
        }
        return res;
    }
}
