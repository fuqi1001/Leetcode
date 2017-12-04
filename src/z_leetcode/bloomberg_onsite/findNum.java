package z_leetcode.bloomberg_onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findNum {
    public static int getSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int findNum() {
        List<Integer> resList = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= 999; i++) {
            int sum = getSum(i);
            if(map.containsKey(sum)) {
                map.get(sum).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            for(int i = 0; i < list.size() ;i++) {
                for(int j = 0; j < list.size(); j++) {
                    int num = list.get(i) * 1000 + list.get(j);
                    if(num >= 100000) resList.add(num);

                }
            }
        }
        return resList.size();
    }

    public static void main(String[] args) {
        System.out.println(findNum());
    }
}
