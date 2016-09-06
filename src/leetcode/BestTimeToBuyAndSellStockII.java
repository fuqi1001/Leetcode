package leetcode;

/**
 * Created by qifu on 16/9/6.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0 ; i < prices.length - 1; i++ ){
            if(prices[i+1] > prices[i]){
                profit += (prices[i+1] - prices[i]);
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices){

        if(prices.length == 0 || prices == null) return 0;

        int profit = 0;
        int index = 0;
        int i;
        for(i = 1; i < prices.length ;i++){
            if(prices[i] < prices[i - 1]){
                profit+= prices[i-1] - prices[index];
                index = i;
            }
        }

        if(prices[i - 1] > prices[index]){
            profit += prices[i - 1] - prices[index];
        }

        return profit;
    }
}
