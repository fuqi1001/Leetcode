package leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by qifu on 17/6/17.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        for(char c: map.keySet()) {
            pq.offer(map.get(c));
        }

        Map<Integer, Integer> coolDown = new HashMap<>();
        int currTime = 0;
        while(!pq.isEmpty() || !coolDown.isEmpty()) {
            if(coolDown.containsKey(currTime - n - 1)) {
                pq.offer(coolDown.remove(currTime - n - 1));
            }
            if(!pq.isEmpty()) {
                int left = pq.poll() - 1;
                if(left != 0) coolDown.put(currTime, left);
            }
            currTime++;
        }
        return currTime;
    }
}
