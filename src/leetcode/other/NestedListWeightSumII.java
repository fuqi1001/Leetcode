package leetcode.other;

import java.util.ArrayList;

/**
 * Created by qifu on 17/1/10.
 */
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList){
        int unweight = 0;
        int weight = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel = new ArrayList<>();

            for(NestedInteger cur : nestedList){
                if(cur.isInteger()){
                    unweight += cur.getInteger();
                } else {
                    nextLevel.addAll(cur.getList());
                }
            }
            weight += unweight;     //unweight不清空,所以每层都加了之前的integer一次
            nestedList = nextLevel;
        }
        return weight;

    }
}
