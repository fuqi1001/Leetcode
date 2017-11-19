package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 16/9/6.
 */
public class TopKFrequentElements {

    //https://discuss.leetcode.com/topic/44225/java-a-simple-accepted-solution/3

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);

            }
            else{
                map.put(num,1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pque = new PriorityQueue<Map.Entry<Integer,Integer>((object1,object2) ->object2.getValue()-object1.getValue());
        pque.addAll(map.entrySet());
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0 ; i < k ; i++){
            ret.add(pque.poll().getKey());
        }
        return ret;
    }



        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int num : nums){
                Integer count = map.get(num);
                if(count == null){
                    count = 0;
                }
                count++;
                map.put(num,count);
            }

            Map<Integer,List<Integer>> listMap = new HashMap<>();
            int maxCount = 0;
            for(int num : map.keySet()){
                int count = map.get(num);
                maxCount = Math.max(maxCount, count);

                List<Integer> list = listMap.get(count);
                if(list == null){
                    list = new ArrayList<Integer>();
                    listMap.put(count,list);
                }
                list.add(num);
            }

            List<Integer> result = new ArrayList<>();
            boolean done = false;
            for(int i = maxCount; i > 0 && !done ;i--){
                List<Integer> list = listMap.get(i);
                if(list != null){
                    result.addAll(list);
                    if(result.size() >= k){
                        done = true;
                        break;
                    }
                }
            }

            while(result.size() > k){
                result.remove(result.size() - 1);
            }

            return result;
        }


    /*
    把相应出现次数的数字放进对应的list里面
    记录数字出现次数
    记录最大次数maxCount
    用hashmap 来储存相应count 的 list
    最后从maxCount 开始往回扫
    知道result里面存了 >= k 个对象为止
     */


    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for(int num : map.keySet()) {
            int freq = map.get(num);
            if(!treeMap.containsKey(freq)) {
                treeMap.put(freq, new ArrayList<>());
            }
            treeMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
