package leetcode.other;

import java.util.List;

/**
 * Created by qifu on 17/7/23.
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        String[] sent = sentence.split(" ");
        for(int i = 0; i < sent.length; i++) {
            sent[i] = replace(sent[i], dict);
        }
        StringBuilder sb = new StringBuilder();
        for(String cur : sent) {
            sb.append(cur);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public String replace(String cur, List<String> dict) {
        int len = 1000;
        String save = new String(cur);
        for(String d : dict) {
            if(cur.equals("dco") && cur.startsWith(d)) {
                System.out.println(d);
            }
            if(cur.startsWith(d)) {
                if(d.length() <= len) {
                    save = d;
                    len = d.length();
                }
            }
        }
        return save;
    }
}
