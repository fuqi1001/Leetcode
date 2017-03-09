package leetcode.z_Bloomberg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/3/6.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        while(count * 2 < row && count * 2 < col) {
            for(int i = count; i < col - count; i++){
                res.add(matrix[count][i]);
            }
            for(int j = count + 1; j < row - count; j++ ) {
                res.add(matrix[j][col - count - 1]);
            }
            if(row - count * 2 == 1 || col - count * 2 == 1) break;

            for(int i = col - 1 - count - 1; i >= count; i--) {
                res.add(matrix[row - 1 - count][i]);
            }

            for(int j = row - 1 - count - 1; j >= count + 1; j--) {
                res.add(matrix[j][count]);
            }
            count++;
        }
        return res;
    }
}
