package leetcode.other;

/**
 * Created by qifu on 16/10/19.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n){
        if(n < 0) return null;
        int[][] res = new int[n][n];

        int xstart = 0;
        int ystart = 0;

        int num = 1;

        while(n > 0){
            if(n == 1){
                res[ystart][xstart] = num++;
                break;
            }
            for(int i = 0 ; i < n - 1;i++){
                res[ystart][xstart + i] = num++;
            }
            for(int i = 0 ; i < n - 1;i++){
                res[ystart + i][xstart+ n - 1] = num++;
            }
            for(int i = 0 ; i < n - 1; i++){
                res[ystart + n - 1][xstart + n - 1 - i] = num++;
            }
            for(int i = 0 ; i < n - 1; i++){
                res[ystart + n - 1 - i][xstart] = num++;
            }

            xstart++;
            ystart++;
            n -= 2;
        }
        return res;
    }
}
