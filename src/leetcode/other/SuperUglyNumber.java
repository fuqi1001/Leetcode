package leetcode.other;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by qifu on 16/10/21.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] times = new int[primes.length];

        res[0] = 1;
        for(int i = 1; i < n ;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < primes.length ;j++){
                min = Math.min(min, primes[j] * res[times[j]]);
            }
            res[i] = min;
            for(int j = 0 ; j < times.length;j++){
                if(min == primes[j] * res[times[j]])
                    times[j]++;
            }
        }
        return res[n - 1];
    }
}
