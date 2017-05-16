package leetcode.other;

/**
 * Created by qifu on 17/5/16.
 */
public class ReshapetheMatrix {

    //O(mn)
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0) return nums;
        int row = nums.length;
        int col = nums[0].length;
        if((row*col) != (r * c)) return nums;
        int x = 0, y = 0;
        int[][] res = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(y == col) {
                    y = 0;
                    x++;
                }
                res[i][j] = nums[x][y++];
            }
        }
        return res;
    }

    //
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }
}
