package z_leetcode.bloomberg_onsite;

import java.util.ArrayList;
import java.util.List;

public class checkCharInString {
    public static int[] check(String s, char c) {
        int[] res = new int[s.length()];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                list.add(i);
            }
        }
        if(list.size() == 0) return res;
        int index = 0;
        int cur = list.get(index);
        if(list.size() == 1) {
            for(int i = 0; i < s.length(); i++) {
                res[i] = Math.abs(cur - i);
            }
        } else {
            int next = cur;
            for(int i = 0; i < s.length(); i++) {
                if(index + 1 < list.size()) {
                    next = list.get(++index);
                }
                if(Math.abs(cur - i) <= Math.abs(next - i)) {
                    res[i] = Math.abs(cur - i);
                } else {
                    cur = next;
                    res[i] = Math.abs(cur - i);
                }
            }
        }
        return res;
    }
}
