package z_leetcode.bloomberg_onsite;

import java.util.*;

public class TopoSort {
    private static class Node {
        public Object val;
        public int pathIn = 0;
        public Node(Object val) {
            this.val = val;
        }
    }

    private static class Graph {
        // node set
        public Set<Node> vertexSet = new HashSet<>();
        // connect edge
        public Map<Node, Set<Node>> adjaNode = new HashMap<>();

        // add node to graph
        public boolean addNode(Node start, Node end) {
            if(!vertexSet.contains(start)) {
                vertexSet.add(start);
            }
            if(!vertexSet.contains(end)){
                vertexSet.add(end);
            }
            if(adjaNode.containsKey(start) && adjaNode.get(start).contains(end)) {
                return false;
            }
            if(adjaNode.containsKey(start)) {
                adjaNode.get(start).add(end);
            } else {
                Set<Node> cur = new HashSet<>();
                cur.add(end);
                adjaNode.put(start, cur);
            }

            end.pathIn++;
            return true;
        }
    }
    private static class KahnTopo {
        private List<Node> result;
        private Queue<Node> setOfZeroIndegree;
        private Graph graph;

        //init
        public KahnTopo(Graph di) {
            this.graph = di;
            this.setOfZeroIndegree = new LinkedList<>();
            this.result = new ArrayList<>();

            for(Node iterator : this.graph.vertexSet) {
                if(iterator.pathIn == 0){
                    this.setOfZeroIndegree.add(iterator);
                }
            }
        }

        //process
        private void process() {
            while(!setOfZeroIndegree.isEmpty()) {
                Node v = setOfZeroIndegree.poll();

                //add top point to res
                result.add(v);
                if(this.graph.adjaNode.keySet().isEmpty()) return;

                for(Node w : this.graph.adjaNode.get(v)) {
                    w.pathIn--;
                    if(w.pathIn == 0) {
                        setOfZeroIndegree.add(w);
                    }
                }
                this.graph.vertexSet.remove(v);
                this.graph.adjaNode.remove(v);
            }
            if(!this.graph.vertexSet.isEmpty()) {
                throw new IllegalArgumentException("Has Cycle !");
            }
        }
        public Iterable<Node> getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        Graph graph = new Graph();
        graph.addNode(A, B);
        graph.addNode(B, C);
        graph.addNode(B, D);
        graph.addNode(D, C);
        graph.addNode(E, C);
        graph.addNode(C, F);

        KahnTopo topo = new KahnTopo(graph);
        topo.process();
        for(Node temp : topo.getResult()){
            System.out.print(temp.val.toString() + "-->");
        }
    }
}
