package leetcode.other;

/**
 * Created by qifu on 16/10/30.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0 ;
        if(grid.length == 0) return res;
        for(int i = 0 ; i < grid.length ;i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1){

                    searchIsLand(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void searchIsLand(char[][] grid, int i, int j){
        grid[i][j] = 0;
        if(i > 0 && grid[i - 1][j] == '1') searchIsLand(grid, i - 1, j);
        if(j > 0 && grid[i][j - 1] == '1') searchIsLand(grid, i, j - 1);
        if(i < grid.length - 1 && grid[i+1][j] == '1') searchIsLand(grid,i+1,j);
        if(j < grid[0].length - 1 && grid[i][j+1] == '1') searchIsLand(grid,i,j+1);
    }
}
