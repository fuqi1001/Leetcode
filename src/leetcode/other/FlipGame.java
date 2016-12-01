package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/12/1.
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() == 0) return res;
        for(int i = 0 ; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+' ){
                char[] temp = s.toCharArray();
                temp[i] = temp[i+1] = '-';
                res.add(String.valueOf(temp));
                temp[i] = temp[i+1] = '+';
            }
        }
        return res;
    }
}
