package leetcode.z_Bloomberg;

import java.util.HashMap;
import java.util.Map;

public class StockPrice {

    public static void stockPrice(String[] str1, String[] str2) {
        Map<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < str1.length;) {
            map1.put(str1[i], Integer.valueOf(str1[i+1]));
            i+=2;
        }
        for(String cur : str2) {
            if(map1.containsKey(cur)){
                System.out.println(cur+" "+map1.get(cur)+" Y");
                map1.put(cur, -1);
            }
        }
        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(entry.getValue() != -1) {
                System.out.println(entry.getKey() +" " +entry.getValue()+" N");
            }
        }

    }
}
