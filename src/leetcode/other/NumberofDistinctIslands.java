package leetcode.other;

import java.util.*;

public class NumberofDistinctIslands {
    private static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                List<List<Integer>> island = new ArrayList<>();
                if(check(i,j,i,j, grid, island)) {
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    public boolean check(int ori_i, int ori_j, int x, int y, int[][] grid, List<List<Integer>> island) {
        int m = grid.length, n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] <= 0) return false;
        island.add(Arrays.asList(x - ori_i, y - ori_j));
        grid[x][y] *= -1;
        for(int d = 0; d < 4; d++) {
            check(ori_i, ori_j, x + move[d][0], y + move[d][1], grid, island);
        }
        return true;
    }
}
