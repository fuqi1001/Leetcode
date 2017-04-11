package leetcode.other;

/**
 * Created by qifu on 16/10/30.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    cover(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void cover(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if(x > 0 && grid[x-1][y] == '1') cover(grid, x-1, y);
        if(x < grid.length - 1 && grid[x+1][y] == '1') cover(grid, x+1, y);
        if(y > 0 && grid[x][y-1] == '1') cover(grid, x, y-1);
        if(y < grid[0].length - 1 && grid[x][y + 1]=='1') cover(grid, x, y+1);
    }
    /*
    找到一个'1' 就递归把上下左右的'1'全部置为'0'
     */
}
