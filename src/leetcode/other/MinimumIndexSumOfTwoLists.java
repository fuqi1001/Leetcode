package leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/5/27.
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }

        Map<Integer, List<String>> _map = new HashMap<>();


        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int index_sum = i + map.get(list2[i]);
                if(_map.containsKey(index_sum)) {
                    _map.get(index_sum).add(list2[i]);
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(list2[i]);
                    _map.put(index_sum, temp);
                }
                //_map.put(index_sum, _map.getOrDefault(index_sum, List<String>).add(list2[i]));
                min = Math.min(min, index_sum);
            }
        }
        List<String> temp = _map.get(min);
        String[] res = new String[temp.size()];
        int index = 0;
        for(String cur : temp) {
            res[index++] = cur;
        }
        return res;
    }
}
