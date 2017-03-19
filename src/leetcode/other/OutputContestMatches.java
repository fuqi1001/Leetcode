package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/3/18.
 */
public class OutputContestMatches {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <=n ; i++) {
            list.add(i+"");
        }
        while(n > 2) {
            list = pack(list);
            for(String cur: list) {
                System.out.println(cur);
            }
            n /= 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        String prefix = "";
        for(String cur : list) {
            sb.append(prefix);
            prefix = ",";
            sb.append(cur);
        }
        sb.append(")");
        return sb.toString();
    }
    public List<String> pack(List<String> list) {
        int size = list.size();
        int left = 0;
        int right = size - 1;
        List<String> cur = new ArrayList<>();

        while(left < right) {
            String temp = "(" + list.get(left)+","+list.get(right)+")";
            cur.add(temp);
            left++;
            right--;
        }
        return cur;
    }
}
