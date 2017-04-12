package leetcode.DPandBackTracking;

import java.util.List;

/**
 * Created by qifu on 16/10/28.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] res = new int[size + 1];
        for(int i = size - 1 ; i >= 0 ;i--){
            List<Integer> temp = triangle.get(i);

            for(int j = 0 ; j < temp.size() ;j++){
                res[j] = Math.min(res[j] , res[j+1]) + temp.get(j);
            }
        }
        return res[0];
    }

    /*
    从下往上求和, 每个点都找下一层同index 与 index + 1的两个位置的和的较小值加
        min(res[j],res[j+1])+ val
        在往上走的过程中 储存值得res数组逐层被缩小
        最后只有res[0]存储了结果

     */
}
