package leetcode.other;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by qifu on 16/10/10.
 */
public class KthSmallestElementinaSortedMatrix {


    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int low = matrix[0][0];
        int high = matrix[len - 1][len - 1];
        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = len - 1;
            for(int i = 0; i < len; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j+1);
            }
            if(count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    //////=========================

    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x,int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }


    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        PriorityQueue<Tuple> pq =  new PriorityQueue<>();
        for(int i = 0 ; i < matrix.length;i++) pq.offer(new Tuple(0,i,matrix[0][i]));
        for(int i = 0 ; i < k - 1; i++){
            Tuple temp = pq.poll();
            if(temp.x == matrix.length - 1) continue;
            pq.offer(new Tuple(temp.x + 1, temp.y, matrix[temp.x + 1][temp.y]));
        }

        return pq.poll().val;
    }



}
