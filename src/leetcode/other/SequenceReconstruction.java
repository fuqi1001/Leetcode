package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/2/16.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer> > graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(List<Integer> seq : seqs){
            for(int i = 0; i < seq.size(); i++){
                graph.putIfAbsent(seq.get(i), new ArrayList<>());
                indegree.putIfAbsent(seq.get(i), 0);

                if(i > 0){
                    graph.get(seq.get(i - 1)).add(seq.get(i));
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        if(indegree.size() != org.length) return false;

        Queue<Integer> queue = new LinkedList();

        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()){
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        int index = 0;

        while(!queue.isEmpty()) {
            if(queue.size() > 1) return false;
            int cur = queue.poll();
            if(org[index++] != cur) return false;

            for(int num : graph.get(cur)){
                indegree.put(num, indegree.get(num) - 1);
                if(indegree.get(num) == 0){
                    queue.add(num);
                }
            }
        }
        return index == org.length;
    }
}
