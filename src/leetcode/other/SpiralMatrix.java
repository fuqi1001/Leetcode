package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/19.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int count = 0;

        while(count * 2 < row && count * 2 < col){
            for(int i = count ; i < col - count ; i++){
                res.add(matrix[count][i]);
            }

            for(int i = count + 1; i < row - count; i++){
                res.add(matrix[i][col - count - 1]);
            }

            if(row - count * 2 == 1 || col - count * 2 == 1) break;

            for(int i = col - 1 - count - 1; i >= count ; i--){
                res.add(matrix[row- count -1][i]);
            }
            for(int i = row - 1 - count -1; i >= count + 1; i--){
                res.add(matrix[i][count]);
            }
            count++;
        }
        return res;
    }



}
