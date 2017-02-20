package leetcode.other;

/**
 * Created by qifu on 17/2/20.
 */
public class TrapWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int result = 0;
        int plank = 0;
        while(i <= j){
            plank = plank < Math.min(height[i], height[j]) ? Math.min(height[i], height[j]) : plank;
            result = height[i] >= height[j] ? result + (plank - height[j--]) : result + (plank - height[i++]);
        }
        return result;
    }
}
