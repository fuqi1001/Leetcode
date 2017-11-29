package z_leetcode.bloomberg_onsite;

import java.util.*;

public class DesignStock {

    Map<String, TreeMap<Integer, ArrayList<Integer>>> map;

    public DesignStock() {
        map = new HashMap<>();
    }

    public void add(String stock, int amount, int price) {
        if(map.containsKey(stock)) {
            TreeMap<Integer, ArrayList<Integer>> temp_tm = map.get(stock);
            ArrayList<Integer> list = new ArrayList<>();
            if(temp_tm.containsKey(price)) {
                list = temp_tm.get(price);
            }
            list.add(amount);
            temp_tm.put(price, list);
            map.put(stock, temp_tm);
        } else {
            TreeMap<Integer, ArrayList<Integer>> temp_tm = new TreeMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(amount);
            temp_tm.put(price, list);
            map.put(stock, temp_tm);
        }
    }
    public int countSum(String stock, int amount) {
        TreeMap<Integer, ArrayList<Integer>> tm = map.get(stock);
        int sum = 0;
        for(Iterator<Integer> it = tm.keySet().iterator(); it.hasNext();) {
            int price = it.next();
            ArrayList<Integer> curPriceList = tm.get(price);
            for(int cur : curPriceList) {
                if(cur < amount) {
                    sum += (cur * price);
                    amount -= cur;
                    curPriceList.remove(0);
                } else {
                    sum += (amount * price);
                    curPriceList.set(0, cur - amount);
                }
            }
        }
        return sum;
    }
}
