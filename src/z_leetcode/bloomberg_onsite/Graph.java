package z_leetcode.bloomberg_onsite;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while(it.hasNext()) {
            i = it.next();
            if(!visited[i]) {
                topSortUtil(i, visited, stack);
            }
        }
        stack.push(new Integer(v));
    }

    void topSort() {
        Stack stack = new Stack();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                topSortUtil(i, visited, stack);
            }
        }
        while(stack.isEmpty() == false) {
            System.out.println(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topSort();
    }
}
