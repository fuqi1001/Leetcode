package leetcode.other;

/**
 * Created by qifu on 16/10/19.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int x_index = 0;
        int y_index = 0;
        int cur_num = 1;

        while(n > 0) {
            if(n == 1) {
                res[x_index][y_index] = cur_num++;
                break;
            }
            for(int i = 0; i < n - 1; i++) {
                res[x_index][y_index+i] = cur_num++;
            }
            for(int i = 0; i < n - 1; i++) {
                res[x_index+i][y_index+n-1] = cur_num++;
            }
            for(int i = 0; i < n - 1; i++) {
                res[x_index+n-1][y_index+n-1-i] = cur_num++;
            }
            for(int i = 0; i < n - 1; i++) {
                res[x_index+n-1-i][y_index] = cur_num++;
            }
            x_index++;
            y_index++;
            n-=2;
        }
        return res;
    }
}
