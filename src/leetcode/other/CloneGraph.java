package leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qifu on 17/2/14.
 */
class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }
    public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if(node == null) return node;
        if(map.containsKey(node.label)) {
            return map.get(node.label);
        } else {
            UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
            map.put(node.label, cloned);
            for(int i = 0; i < node.neighbors.size(); i++) {
                cloned.neighbors.add(dfs(node.neighbors.get(i), map));
            }
            return cloned;
        }
    }
}
