package leetcode.z_IXL;

import java.util.*;

/**
 * Created by qifu on 17/4/25.
 */
public class mostFrequentElement {
    public int freq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int res = -1;
        for(int num : map.keySet()) {
            int count = map.get(num);
            if(count > maxCount) {
                res = num;
            }
        }
        return res;
    }
    public int freq(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int maxCount = 0;
        int prev = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == prev) {
                count++;
            } else {
                if(count > maxCount) {
                    maxCount = count;
                    res = nums[i];
                }
                prev = nums[i];
                count = 1;
            }
        }
        return res;
    }


    //top k O(n * logk) k is number of unique element
    public List<Integer> topK(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        int maxCount = 0;
        for(int num : map.keySet()) {
            int count = map.get(num);
            maxCount = Math.max(count, maxCount);

            List<Integer> list = listMap.get(count);
            if(list == null) {
                list = new ArrayList<>();
                listMap.put(num, list);
            }
            list.add(num);
        }

        List<Integer> res = new ArrayList<>();
        boolean done = false;
        for(int i = maxCount; i > 0 && !done; i--) {
            List<Integer> list = listMap.get(i);
            if(list!=null) {
                res.addAll(list);
                if(res.size() >= k) {
                    done = true;
                    break;
                }
            }
        }
        while(res.size() > k) {
            res.remove(res.size() - 1);
        }
        return res;
    }

    //use treemap
    public List<Integer> topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()) {
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }
        List<Integer> res = new ArrayList<>();
        while(res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }

    //bucket sort  O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
