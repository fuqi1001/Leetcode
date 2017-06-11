package leetcode.other;

/**
 * Created by qifu on 17/6/11.
 */
public class AddBoldTaginString {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int len = 0;
            for(String cur : dict) {
                if(s.startsWith(cur, i)) {
                    len = Math.max(len, cur.length());
                }
            }

            for(int j = i; j < i + len; j++) {
                bold[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!bold[i]) {
                sb.append(s.charAt(i));
                continue;
            }
            int index = i;
            while(index < s.length() && bold[index] == true) {
                index++;
            }
            sb.append("<b>"+s.substring(i,index)+"</b>");
            i = index - 1;
        }
        return sb.toString();
    }
}
