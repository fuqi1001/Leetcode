package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/9/15.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex < 0) return result;

        for(int i = 0 ; i < rowIndex + 1; i++){
            result.add(0,1);
            for(int j = 1; j < result.size() - 1; j++){
                result.set(j,result.get(j) + result.get(j+1));
            }
        }
        return result;
    }
}
