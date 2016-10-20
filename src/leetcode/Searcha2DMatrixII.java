package leetcode;

/**
 * Created by qifu on 16/10/20.
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        if(matrix[0] == null || matrix[0].length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = m - 1;
        int y = 0;

        while( x >= 0 && y < n ){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) x--;
            else y++;
        }
        return false;

    }
}
