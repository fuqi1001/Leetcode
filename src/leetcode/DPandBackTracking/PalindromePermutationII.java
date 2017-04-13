package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/2/6.
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
        if(odd > 1) return res;
        String mid = "";
        List<Character> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if(value % 2 != 0) mid += key;
            for(int i = 0; i < value / 2; i++) {
                list.add(key);
            }
        }
        boolean[] visited = new boolean[list.size()];
        StringBuilder sb = new StringBuilder();
        helper(res, list, visited, sb, mid);
        return res;
    }

    private void helper(List<String> res, List<Character> list, boolean[] visited, StringBuilder sb, String mid) {
        if(sb.length() == list.size()) {
            String str = sb.toString() + mid + sb.reverse().toString();
            res.add(str);
            sb.reverse();
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            if(i > 0 && list.get(i) == list.get(i - 1) && visited[i - 1] == false) continue;
            if(visited[i] == false) {
                visited[i] = true;
                sb.append(list.get(i));
                helper(res, list, visited, sb, mid);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
