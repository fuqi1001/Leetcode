package leetcode.DPandBackTracking;

public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] hold = new int[len];
        int[] empty = new int[len];

        hold[0] = -1 * prices[0];
        empty[0] = 0;
        for(int i = 1; i < len; i++) {
            hold[i] = Math.max(hold[i - 1], empty[i - 1] - prices[i]);
            empty[i] = Math.max(empty[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return empty[len - 1];
    }

    //
    public int maxProfit_O1Space(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int hold = -1 * prices[0];
        int hold_prev = hold;
        int empty = 0;
        int empty_prev = 0;
        for (int i = 1; i < len; i++) {
            hold = Math.max(hold_prev, empty_prev - prices[i]);
            hold_prev = hold;
            empty = Math.max(empty_prev, hold_prev + prices[i] - fee);
            empty_prev = empty;
        }
        return empty;
    }
}
