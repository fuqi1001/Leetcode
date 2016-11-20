package leetcode.other;

/**
 * Created by qifu on 16/9/6.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int profit = 0;
        int minValue = Integer.MAX_VALUE;
        for(int pr : prices){
            minValue = pr < minValue ? pr : minValue;
            profit = (pr - minValue) > profit ? (pr - minValue) : profit;
        }
        return profit;
    }


}
