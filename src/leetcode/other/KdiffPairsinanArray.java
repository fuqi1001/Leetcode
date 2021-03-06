package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/3/4.
 */
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(!list.contains(num)) {
                list.add(num);
            }
        }
        int count = 0;
        if(k != 0) {
            for(int i : list) {
                /*for(int j = i + 1; j < list.size(); j++){
                    if(Math.abs(list.get(i)-list.get(j)) == k) count++;
                }*/
                int temp1 = i + k;
                int temp2 = i - k;
                if(list.contains(temp1) ) count++;
                if(list.contains(temp2)) count++;
            }
            count /= 2;
        } else {
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                int val = entry.getValue();
                if(val >= 2) count++;
            }
        }
        return count;
    }

    //
    public int findPairs(int[] nums, int k) {
        if (k<0) return 0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int cnt=0;
        for (int n: map.keySet()) {
            int m=n+k;
            if (m!=n && map.containsKey(m)) cnt++;
            if (m==n && map.get(n)>=2) cnt++;
        }
        return cnt;
    }

    //
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> seenNum = new HashSet<>();
        Set<String> seenPair = new HashSet<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int prev = nums[i] - k;
            if (seenNum.contains(prev) && !seenPair.contains(prev + "," + nums[i])) {
                result++;
                seenPair.add(prev + "," + nums[i]);
            }
            seenNum.add(nums[i]);
        }
        return result;
    }

    ///
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                if(Math.abs(nums[i] - nums[j]) == k) count++;
            }
        }
        return count;
    }
}

///
