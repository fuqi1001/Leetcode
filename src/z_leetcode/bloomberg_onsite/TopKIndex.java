package z_leetcode.bloomberg_onsite;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKIndex {
    class Node {
        int key, value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    PriorityQueue<Node> pq;

    public TopKIndex() {
        pq = new PriorityQueue<Node>((o1, o2) -> o1.value - o2.value);
    }

    public List<Integer> getTopIndex(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            pq.add(new Node(i, nums[i]));
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(pq.poll().key);
        }
        return res;
    }

}
