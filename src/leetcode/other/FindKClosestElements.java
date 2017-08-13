package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/8/13.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (o1, o2) -> {
            int ad = Math.abs(o1 - x);
            int bc = Math.abs(o2 - x);
            if(ad != bc) return ad - bc;
            else return o1 - o2;
        });
        arr = new ArrayList<>(arr.subList(0, Math.min(k, arr.size())));
        Collections.sort(arr);
        return arr;
    }

    // other way
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int cur : arr) {
            int num = x - cur;
            int dis = Math.abs(num);
            if(map.containsKey(dis)) {
                map.get(dis).add(num);
            } else {
                List<Integer> ttemp = new ArrayList<>();
                ttemp.add(num);
                map.put(dis, ttemp);
            }
        }
        int index = 0;
        List<Integer> num_list = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(index >= k)break;
            //Integer key = entry.getKey();
            List<Integer> temp_list = entry.getValue();
            Collections.sort(temp_list, (o1, o2) -> (o2 - o1));
            for(int cur : temp_list) {
                if(index >= k) break;
                if(cur < 0) {
                    num_list.add(x + entry.getKey());
                } else {
                    num_list.add(x - entry.getKey());
                }
                index++;
            }
        }
        int[] temp_num = new int[num_list.size()];
        index = 0;
        for(int cur : num_list) {
            temp_num[index++] = cur;
        }
        Arrays.sort(temp_num);
        List<Integer> result = new ArrayList<>();
        index = 0;
        for(int cur : temp_num) {
            if(index >= k) break;
            result.add(cur);
            index++;
        }
        return result;
    }

}
