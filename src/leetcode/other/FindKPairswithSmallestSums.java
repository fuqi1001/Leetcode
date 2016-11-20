package leetcode.other;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by qifu on 16/11/8.
 */
public class FindKPairswithSmallestSums {
    class Tuple  implements Comparable<Tuple>{
        int x,y,val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }


    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int m = nums1.length;
        int n = nums2.length;
        List<int[]> res = new ArrayList<>();
        if(m == 0 || n == 0|| nums1 ==  null || nums2 == null || k<=0) return res;

        for(int i = 0 ; i < n; i++) pq.offer(new Tuple(0,i,nums1[0] + nums2[i]));
        for(int i = 0 ; i < Math.min(k, m * n); i++){
            Tuple temp = pq.poll();
            res.add(new int[] {nums1[temp.x] , nums2[temp.y]});
            if(temp.x == m - 1) continue;
            pq.offer(new Tuple(temp.x + 1, temp.y, nums1[temp.x + 1] + nums2[temp.y]));
        }
        return res;
    }
}
