package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 16/11/18.
 */
public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();

        for(String[] ticket : tickets){
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    private void dfs(String departure){
        PriorityQueue<String> arrival = flights.get(departure);
        while(arrival != null && !arrival.isEmpty()){
            dfs(arrival.poll());
        }
        path.addFirst(departure);
    }
}
