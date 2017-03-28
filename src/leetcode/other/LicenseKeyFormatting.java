package leetcode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qifu on 17/3/28.
 */
public class LicenseKeyFormatting {
    //
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) != '-')
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
        }
        return sb.reverse().toString().toUpperCase();
    }


    //----------------------------------------
    public String licenseKeyFormatting(String S, int K) {
        String[] str = S.split("\\-");
        List<Character> list = new ArrayList<>();
        for(String cur : str) {
            for(char c : cur.toCharArray()) {
                list.add(c);
            }
        }
        Collections.reverse(list);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
            count++;
            if(count == K) {
                sb.append('-');
                count = 0;
            }
        }
        sb.reverse();
        String res = sb.toString();
        if(res.length() > 0 && res.charAt(0) == '-') {
            res = res.substring(1);
        }
        return res.toUpperCase();
    }


}
