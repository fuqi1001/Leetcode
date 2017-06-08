package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/2/14.
 */
public class SimplifyPath {
    //deque
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for(String cur : path.split("/")){
            if(cur.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!skip.contains(cur)) {
                stack.push(cur);
            }
        }
        String res = "";
        for(String cur : stack){
            res = "/" + cur + res;
        }
        return res.isEmpty() ? "/" : res;
    }

    //stack
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".",""));
        for(String cur : path.split("/")) {
            if(cur.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if(!skip.contains(cur)) {
                stack.push(cur);
            }
        }

        String res = "";
        while(!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
