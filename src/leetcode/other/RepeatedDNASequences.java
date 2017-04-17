package leetcode.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 17/4/17.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> first_round = new HashSet<>();
        Set<Integer> second_round = new HashSet<>();        //防止结果中出现重复的
        List<String> res = new ArrayList<>();

        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for(int i = 0; i < s.length() - 9; i++) {
            int cur = 0;
            for(int j = i; j < i + 10; j++) {
                cur <<= 2;
                cur |= map[s.charAt(j) - 'A'];
            }
            if(!first_round.add(cur) && second_round.add(cur)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
