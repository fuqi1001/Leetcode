package leetcode.Implement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/2/10.
 */
public class EncodeandDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(String.valueOf(str.length()) + "#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int start = 0;
        while(start < s.length()){
            int idx = s.indexOf("#", start);
            int len = Integer.parseInt(s.substring(start, idx));
            res.add(s.substring(idx + 1, idx + len + 1));
            start = idx + len + 1;
        }
        return res;
    }
}
