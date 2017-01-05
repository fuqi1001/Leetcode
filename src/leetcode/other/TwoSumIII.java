package leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/1/5.
 */
public class TwoSumIII {

    List<Integer> num = new ArrayList<>();
    Map<Integer, Integer> map= new HashMap<>();


    // Add the number to an internal data structure.
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        } else{
            map.put(number, 1);
            num.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(int i = 0 ; i < num.size(); i++){
            int num1 = num.get(i);
            int num2 = value - num1;

            if((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
