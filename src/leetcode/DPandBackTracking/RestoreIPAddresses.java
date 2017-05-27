package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/2/10.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res;
        generate(res, list, s, 0);
        return res;
    }
    public void generate(List<String> res, List<String> list, String s, int start) {
        if(list.size() == 4) {
            if(start != s.length()) return;

            StringBuilder sb = new StringBuilder();
            for(String cur : list) {
                sb.append(cur+".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for(int i = start; i < s.length() && i < start + 3; i++) {
            String cur = s.substring(start, i+1);
            if(isValid(cur)) {
                list.add(cur);
                generate(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isValid(String num) {
        if(num.charAt(0) == '0') return num.equals("0");
        int number = Integer.parseInt(num);
        return (number >= 0 && number <= 255);
    }
}
