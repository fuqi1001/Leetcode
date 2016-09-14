package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/9/13.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows){

        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        List<Integer> pre = first;
        for(int i = 2 ; i <= numRows ; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 0 ; j < pre.size() - 1 ; j++){
                temp.add(pre.indexOf(j)+pre.indexOf(j+1));
            }
            temp.add(1);
            pre = temp;
            result.add(temp);
        }
        return result;
    }
}
