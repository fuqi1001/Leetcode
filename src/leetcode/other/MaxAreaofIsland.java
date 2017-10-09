package leetcode.other;

public class MaxAreaofIsland {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int max = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }


    public void dfs(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[x][y] == 0) return;
        count++;
        grid[x][y] = 0;
        if(x > 0) dfs(grid, x-1, y);
        if(x < m - 1) dfs(grid, x+1, y);
        if(y > 0) dfs(grid, x, y-1);
        if(y < n - 1) dfs(grid, x, y+1);
    }
}
