package leetcode.bit;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qifu on 17/3/30.
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            }
        });

        for(String cur : d) {
            int index = 0;
            for(char c : s.toCharArray()) {
                if(index < s.length() && c == cur.charAt(index)) index++;
                if(index == cur.length()) return cur;
            }
        }
        return "";
    }
}
