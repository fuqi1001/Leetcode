package leetcode.other;

/**
 * Created by qifu on 16/10/20.
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        if(matrix[0] == null || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int x_index = row - 1;
        int y_index = 0;
        while(x_index >= 0 && y_index < col) {
            int cur = matrix[x_index][y_index];
            if(cur == target) return true;
            else if(cur < target) {
                y_index++;
            } else if(cur > target) {
                x_index--;
            }
        }
        return false;
    }
}
