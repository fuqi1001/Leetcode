package z_leetcode.bloomberg_onsite;

import java.util.PriorityQueue;

public class MedianNumber {
    PriorityQueue<Integer> pq;

    public MedianNumber() {
        pq = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
    }

    public void add(int num) {
        pq.add(num);
    }
    public int pop() {
        int size = pq.size();
        int[] temp = new int[(size / 2) + 1];
        int index = 0;
        while(index <= size / 2) {
            temp[index++] = pq.poll();
        }
        index--;
        while(index > 0) {
            pq.add(temp[index--]);
        }
        return temp[temp.length  - 1];
    }
    public static void main(String[] args) {
        MedianNumber t = new MedianNumber();
        t.add(1);
        t.add(2);t.add(3);t.add(4);t.add(5);t.add(6);
        System.out.println(t.pop());
    }
}
