package leetcode.other;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by qifu on 17/1/5.
 */
public class ThirdMaximumNumber {
    //4144
    public int thirdMax(int[] nums){
        int max, mid, small;

        int count = 0;
        max = mid = small = Integer.MIN_VALUE;

        for(int num : nums){
            if(count > 0 && max == num || count > 1 && mid == num) continue;

            count++;

            if(num > max){
                small = mid;
                mid = max;
                max = num;
            } else if( num > mid){
                small = mid;
                mid = num;
            } else if( num > small){
                small = num;
            }


        }
        if(count >= 3 ){
            return small;
        }else {
            return max;
        }
    }

    //
    public int thirdMax(int[] nums)  {
        int size = 3;
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums) {
            if(set.contains(num)) continue;
            if(set.size() < num) {
                set.add(num);
            } else if(set.size() == size && set.first() < num){
                set.remove(set.first());
                set.add(num);
            }
        }
        return set.size() == size ? set.first() : set.last();
    }

    //
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.contains(num)) {
                pq.offer(num);
                set.add(num);
                if(pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if(pq.size() < 3) {
            while(pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
