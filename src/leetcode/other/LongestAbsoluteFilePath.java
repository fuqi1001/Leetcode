package leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qifu on 16/10/27.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            /*
                "\t"在split以后已经被转义为tab了
                所以寻找lastIndexOf("\t")的时候
                已经被当做一个tab只占一个字符了
             */
            int len = s.substring(level).length();
            if(s.contains(".")) {
                res = Math.max(res, map.get(level) + len);
            } else {
                map.put(level + 1, map.get(level) + len + 1);   // "\t"转换为"\" len + 1
            }
        }
        return res;
    }

    public int lengthLongestPath(String input){
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while(level + 1< stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.substring(level).length() + 1;
            stack.push(len);
            if(s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }

    //
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int res = 0;
        for(String cur : paths) {
            int level = cur.lastIndexOf("\t") + 1;
            stack[level + 1] = stack[level] + cur.substring(level).length() + 1; //加上末尾的"\"
            if(cur.contains(".")) {
                res = Math.max(res, stack[level + 1] - 1); //减掉末尾的"\"
            }
        }
        return res;
    }
}
