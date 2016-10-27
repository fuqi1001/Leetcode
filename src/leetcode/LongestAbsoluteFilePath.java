package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qifu on 16/10/27.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int res= 0 ;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        for(String s : input.split("\n")){
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if(s.contains(".")){
                res = Math.max(res, map.get(level) + len);
            }else{
                map.put(level + 1, map.get(level) + len + 1);
            }
        }
        return res;
    }

    public int lengthLongestPath(String input){
        int res = 0;
        String[] dir = input.split("\n");

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < dir.length; i++){
            String cur = dir[i];
            int curLen = cur.length();
            int level = cur.lastIndexOf('\t') + 1;
            while(level < stack.size()){
                stack.pop();            //相当于每次只存根目录
            }
            if(!stack.empty()){
                curLen += stack.peek();
            }
            stack.push(curLen - level);

            if(cur.contains(".")){
                res = Integer.max(res,curLen);
            }
        }
        return res;
    }
}
