package z_leetcode.bloomberg_onsite;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class TopKwithpq<E extends Comparable> {
    private PriorityQueue<E> pq;
    private int maxSize;

    public TopKwithpq(int maxSize) {
        if(maxSize <= 0) throw new IllegalArgumentException();
        this.maxSize = maxSize;
        this.pq = new PriorityQueue<>(maxSize,(o1,o2)-> {return o2.compareTo(o1);});
    }

    private void add(E e) {
        if(pq.size() < maxSize) {
            pq.add(e);
        } else {
            E peek = pq.peek();
            if(e.compareTo(peek) < 0) {
                pq.poll();
                pq.add(e);
            }
        }
    }

    public List<E> sortedList() {
        List<E> list = new ArrayList<E>(pq);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        final TopKwithpq prq = new TopKwithpq(10);
        Random random = new Random();
        int rNum = 0;
        System.out.println("100个0~999的随机数----------");
        for(int i = 0; i < 100; i++) {
            rNum = random.nextInt(1000);
            prq.add(rNum);
        }
        System.out.println("pq本身无序------------------");
        Iterable<Integer> it = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return prq.pq.iterator();
            }
        };
        for(Integer item : it) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("PriorityQueue 排序后的遍历：-----------------------------------");
        while(!prq.pq.isEmpty()) {
            System.out.print(prq.pq.poll() +", ");
        }
    }
}
