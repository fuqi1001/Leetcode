package leetcode;

/**
 * Created by qifu on 16/10/21.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for(int i = 0 ; i < len - 1;i++){
            for(int j = 0 ; j < len - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
            }
        }
        for(int i = 0 ; i < len / 2 ; i++){
            for(int j = 0 ; j < len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }
    }

    public void rotate(int[][] matrix){
        int len = matrix.length;

        for(int i = 0 ; i < len / 2 ;i++){
            for(int j = 0 ; j <  (len + 1) / 2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}
