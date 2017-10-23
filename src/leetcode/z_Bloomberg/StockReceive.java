package leetcode.z_Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockReceive {
    Map<String, Stock> map;
    class Stock {
        List<Integer> prices;
        List<Integer> most_recent;
        int max;
        int min;
        public Stock() {
            this.prices = new ArrayList<>();
            this.most_recent = new ArrayList<>();
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE
        }

        public void setMax(int max) {
            this.max = max;
        }
        public void setMin(int min) {
            this.min = min;
        }
    }
    public StockReceive {
        map = new HashMap<>();
    }
    public void receivePrice(String name, int price) {
        if(!map.containsKey(name)) {
            map.put(name, new Stock());
        }
        map.get(name).prices.add(price);
        if(map.get(name).most_recent.size() == 5) {
            map.get(name).most_recent.remove(0);
        }
        map.get(name).most_recent.add(price);
        if(price > map.get(name).max){
            map.get(name).setMax(price);
        }
        if(price < map.get(name).min) {
            map.get(name).setMin(price);
        }
    }
    public int getAve(String name) {
        List<Integer> prices = map.get(name).most_recent;
        int sum = 0;
        for(int num : prices) {
            sum += num;
        }
        return sum / prices.size();
    }

}
