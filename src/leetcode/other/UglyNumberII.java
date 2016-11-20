package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 16/10/21.
 */
public class UglyNumberII {
    //O(n)
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n ; i++){
            int last = res.get(i - 1);
            while(res.get(p2) * 2 <= last) p2++;
            while(res.get(p3) * 3 <= last) p3++;
            while(res.get(p5) * 5 <= last) p5++;

            res.add(Math.min(Math.min(res.get(p2) * 2, res.get(p3) * 3), res.get(p5) * 5 ));
        }
        return res.get(n - 1);
    }

    //nlogn
    public int nthUglyNumber(int n){
        Queue<Long> queue= new PriorityQueue<>();
        HashSet<Long> inforQueue = new HashSet<>();
        Long[] primes = new Long[3];

        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);

        for(int i = 0 ; i < 3; i++){
            queue.add(primes[i]);
            inforQueue.add(primes[i]);
        }
        Long number = Long.valueOf(1);
        for(int i = 1; i < n ;i++){
            number = queue.poll();
            for(int j = 0 ; j < 3 ;j++){
                if(!inforQueue.contains(primes[j] * number)){
                    queue.add(number * primes[j]);
                    inforQueue.add(number * primes[j]);
                }
            }
        }
        return number.intValue();
    }
}
