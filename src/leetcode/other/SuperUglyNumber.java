package leetcode.other;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by qifu on 16/10/21.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] count = new int[primes.length];
        int[] res = new int[n];

        res[0] = 1;     //1是第一个
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            //循环整个primes数组，每一个质数都用一遍，找到最小的append到res里面
            for(int j = 0; j < primes.length; j++) {
                min = Math.min(min, res[count[j]] * primes[j]);
                //res[count[j]] 表示第j个prime 用了count[j]次了的结果

            }
            res[i] = min;
            for(int j = 0; j < primes.length; j++) {
                if(min == res[count[j]] * primes[j]) {
                    count[j]++;
                }
            }
        }
        return res[n - 1];
    }
}
