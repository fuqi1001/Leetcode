package leetcode.z_amazon;

import java.util.PriorityQueue;

public class kClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((point1, point2) -> distance(point2) - distance(point1));
        for(int[] curr: points) {
            pq.offer(curr);
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        while(!pq.isEmpty()) {
            res[--k] = pq.poll();
        }
        return res;
    }

    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
