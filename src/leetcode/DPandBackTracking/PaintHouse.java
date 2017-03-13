package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/3/13.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int red = 0, green = 0, blue = 0;
        for(int i = 0; i < costs.length; i++) {
            int last_red = red, last_green = green, last_blue = blue;
            red = costs[i][0] + Math.min(last_green, last_blue);
            green = costs[i][1] + Math.min(last_red, last_blue);
            blue = costs[i][2] + Math.min(last_red, last_green);
        }
        return Math.min(Math.min(red,green),blue);
    }
}
