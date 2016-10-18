package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/18.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n == 0){
            res.add(0);
            return res;
        }

        res = grayCode(n - 1);
        int addNum =  1 << (n - 1);
        int size = res.size();
        for(int i = size-1 ; i >= 0 ; i--){
            res.add(addNum + res.get(i));
        }
        return res;

    }
}
