package z_leetcode.bloomberg_onsite;

public class LongestPathInMatrix {
    public int findLongestFromACell(int[][] grid, int x, int y, int[][] dp) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;

        if(dp[x][y] != -1) return dp[x][y];

        if(y < grid[0].length - 1 && (grid[x][y] + 1 == grid[x][y+1])) {
            return dp[x][y] = 1 + findLongestFromACell(grid, x, y+1, dp);
        }
        if(y > 0 && (grid[x][y] + 1 == grid[x][y-1])) {
            return dp[x][y] = 1 + findLongestFromACell(grid, x, y-1, dp);
        }
        if(x < grid.length - 1 && (grid[x][y] + 1 == grid[x+1][y])) {
            return dp[x][y] = 1 + findLongestFromACell(grid, x+1, y, dp);
        }
        if(x > 0 && (grid[x][y] + 1 == grid[x-1][y])) {
            return dp[x][y] = 1 + findLongestFromACell(grid, x-1, y, dp);
        }

        return dp[x][y] = 1;
    }

    public int findLongestOverAll(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 1;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(dp[i][j] == -1) {
                    findLongestFromACell(grid, i, j, dp);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int  mat[][] = { {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7} };
        test t = new test();
        System.out.println(t.findLongestOverAll(mat));


    }
}
