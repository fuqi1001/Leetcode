package leetcode.DPandBackTracking;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int low = prices[0];
        int max = 0;
        for(int cur : prices) {
            if(cur > low) {
                max = Math.max(max, cur - low);
            } else {
                low = cur;
            }
        }
        return max;
    }
}
