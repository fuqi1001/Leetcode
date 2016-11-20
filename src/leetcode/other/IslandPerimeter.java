package leetcode.other;

/**
 * Created by qifu on 16/11/20.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {

        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int temp = 4;
                if(grid[i][j] == 1){
                    if(i - 1 >= 0 && grid[i-1][j] == 1){
                        temp -= 1;
                    }
                    if(i + 1 < m && grid[i+1][j] == 1){
                        temp -= 1;
                    }
                    if(j - 1 >= 0 && grid[i][j-1] ==1){
                        temp -= 1;
                    }
                    if(j + 1 < n && grid[i][j+1] ==1){
                        temp -= 1;
                    }

                    res += temp;
                }
            }
        }
        return res;
    }
}
