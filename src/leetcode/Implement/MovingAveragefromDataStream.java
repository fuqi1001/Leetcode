package leetcode.Implement;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 16/11/30.
 */
public class MovingAveragefromDataStream {
    int[] num;
    long sum;
    int insert;
    int count;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        num = new int[size]
        sum = 0;
        insert = 0;
        count = 0;
    }

    public double next(int val) {
        if(count < num.length) count++;

        sum -= num[insert];
        sum += val;
        num[insert] = val;
        insert = (insert + 1) % num.length;

        return (double)sum / count;
    }

    //


    Queue<Integer> window;
    int sum = 0;
    int s;
    public MovingAverage(int size){
        window = new LinkedList<>();
        s = size;
    }

    public double next(int val){
        if(window.size() == s){
            sum -= window.poll();
        }
        window.offer(val);
        sum += val;
        return (double) sum / window.size();
    }
}
