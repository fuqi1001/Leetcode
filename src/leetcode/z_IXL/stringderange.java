package leetcode.z_IXL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/4/24.
 */
public class stringderange {
    public static void main(String[] args) {
        derangement("abc");
        System.out.println("===========");
    }

    public static void derangement(String strs) {
        char[] ctr = strs.toCharArray();
        int len = strs.length();
        char[] origin = ctr;
        derangement( origin, new boolean[len], new StringBuilder(), new ArrayList<>());
    }

    public static void derangement( char[] origin, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == origin.length ) {
            //System.out.println(sb.toString());
            result.add(sb.toString());
        }
        for (int i = 0; i < origin.length; i++) {
            if(used[i] == true || (i != 0 && origin[i] == origin[i-1] && used[i-1] == true) || sb.length() == i) continue;
            used[i] = true;
            sb.append(origin[i]);
            derangement( origin, used, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
