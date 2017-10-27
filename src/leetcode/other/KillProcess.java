package leetcode.other;

import java.util.*;

public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        //store process tree as an adjacency list
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++) {
            adjListMap.putIfAbsent(ppid.get(i), new LinkedList<>());
            adjListMap.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(kill);
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            res.add(cur);
            List<Integer> list = adjListMap.get(cur);
            if(list == null) continue;
            stack.addAll(list);
        }
        return res;
    }
}
