package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by qifu on 16/9/29.
 */
public class QueueReconstructionbyHeight {

    class listComparator implements Comparator<int[]>{
        public int compare(int[] first ,int[] second){
            if(first[0] != second[0]) return second[0] - first[0];
            else return first[1] - second[1];
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new listComparator());

        for(int i = 0; i < people.length;i++){
            queue.offer(people[i]);
        }
        while(queue.size()!=0){
            insert(list,queue.poll());
        }
        for(int i = 0 ;i < people.length;i++){
            result[i] = list.get(i);
        }
        return result;

    }

    private void insert(List<int[]> list,int[] element){
        if(list.size() == 0){
            list.add(element);
            return;
        }
        int count = 0;
        for(int i = 0 ; i < list.size() ;i++){
            if(count == element[1]){
                list.add(i,element);
                return;
            }
            else if(list.get(i)[0] > element[0]){
                count++;
            }
        }
        list.add(element);
    }



}
