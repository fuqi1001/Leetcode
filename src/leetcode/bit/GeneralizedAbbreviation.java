package leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/3/23.
 */
public class GeneralizedAbbreviation {


    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(list, sb, word.toCharArray(), 0, 0);
        return list;
    }
    private void helper(List<String> list, StringBuilder sb, char[] c, int cur_index, int count) {
        int len = sb.length();
        if(cur_index == c.length) {
            if(count > 0) {
                sb.append(count);
            }
            list.add(sb.toString());
        } else {
            helper(list,sb, c, cur_index + 1, count + 1);   //对c[i]缩写
            if(count > 0) sb.append(count);     //对c[i]不缩写，把之前缩写的数字append上，重新开始计数
            helper(list,sb.append(c[cur_index]), c, cur_index+1, 0);
        }
        sb.setLength(len);
    }
}
