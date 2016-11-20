package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 16/11/20.
 */
public class OptimalAccountBalancing {
    //A group of friends went on holiday and sometimes lent each other money.
    //For example, Alice paid for Bill's lunch for $10.
    //Then later Chris gave Alice $5 for a taxi ride.
    //We can model each transaction as a tuple (x, y, z) which means person x gave person y $z.
    //Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID),
    //the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
    //Given a list of transactions between a group of people,
    //return the minimum number of transactions required to settle the debt.


    //Input:
    //     [[0,1,10], [2,0,5]]
    // Output:
    //        2
    // Explanation:
    // Person #0 gave person #1 $10.
    //        Person #2 gave person #0 $5.
    // Two transactions are needed.
    // One way to settle the debt is person #1 pays person #0 and #2 $5 each.

    //Input:
    //        [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

    //Output:
    //        1

    //Explanation:
    // Person #0 gave person #1 $10.
    //        Person #1 gave person #0 $1.
    //        Person #1 gave person #2 $5.
    //        Person #2 gave person #0 $5.

    //        Therefore, person #1 only need to give person #0 $4,
    // and all debt is settled.


    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] t : transactions){
            map.put(t[1], map.getOrDefault(t[1],0) - t[2]);
            map.put(t[0], map.getOrDefault(t[0],0) + t[2]);
        }
        int[] count = new int[1];
        helper(map, count);
        return count[0];
    }
    private int getMax(Map<Integer,Integer> map){
        int max = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(max == -1) max = entry.getKey();
            else if(entry.getValue() > map.get(max)){
                max = entry.getKey();
            }
        }
        return max;
    }
    private int getMin(Map<Integer,Integer> map){
        int min = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(min == -1) min = entry.getKey();
            else if(entry.getValue() < map.get(min)){
                min = entry.getKey();
            }
        }
        return min;
    }
    private void helper(Map<Integer, Integer> map, int[] count){
        int max =  getMax(map);
        int min = getMin(map);

        if(map.get(max) == 0 && map.get(min) == 0) return;

        int minValue = Math.min(map.get(max), -map.get(min));
        map.put(max, map.get(max)-minValue);
        map.put(min, map.get(min)+minValue);
        count[0]++;
        helper(map,count);
    }

}
