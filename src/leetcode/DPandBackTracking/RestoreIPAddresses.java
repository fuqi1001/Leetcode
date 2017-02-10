package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/2/10.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            return res;
        }
        helper(res, list, s, 0);
        return res;
    }
    private void helper(ArrayList<String> res, ArrayList<String> list, String s, int start){
        if(list.size() == 4) {
            if(start != s.length()){
                return;
            }

            StringBuilder sb = new StringBuilder();
            for(String cur : list){
                sb.append(cur + ".");

            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for(int i = start; i < s.length() && i < start + 3; i++){
            String temp = s.substring(start, i + 1);
            if(isValid(temp)){
                list.add(temp);
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isValid(String num){
        if(num.charAt(0) == '0'){
            return num.equals("0");
        }
        int digit = Integer.parseInt(num);
        return digit >= 0 && digit <= 255;
    }
}
