package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/3/22.
 */
public class foursumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        for(int i = 0 ; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <len; j++) {
                int sum = -1 * (C[i] + D[j]);
                if(map.containsKey(sum)) {
                    count+=map.get(sum);
                }
            }
        }
        return count;
    }
}
