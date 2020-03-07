package leetcode.z_amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    static class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // O(n) time & space
    public static int treasureIsland(char[][] island) {
        if (island == null || island.length == 0) return 0;

        int steps = 0;
        Queue<Coordinate> que = new LinkedList<>();
        que.add(new Coordinate(0,0));
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int rows = island.length;
        int cols = island[0].length;

        // bfs
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Coordinate cur = que.poll();
                int x = cur.x;
                int y = cur.y;
                if (island[x][y] == 'X') return steps;

                for(int[]dir: dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX >= 0 && nextX <= rows && nextY >= 0 && nextY < cols && island[nextX][nextY] != 'D' && !visited[nextX][nextY]) {
                        que.add(new Coordinate(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    private int distance = Integer.MAX_VALUE;
    public int findShortestRoute(char[][] island) {
        if (island == null) {
            return -1;
        }
        int rows = island.length;
        int cols = island[0].length;
        boolean[][] visited = new boolean[rows][cols];
        dfs(island, 0, 0, visited, 0);
        return distance;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited, int currDistance) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'D' || visited[i][j]) return;
        if (grid[i][j] == 'X') {
            distance = Math.min(distance, currDistance);
            return;
        }

        visited[i][j] = true;
        dfs(grid, i, j - 1, visited, currDistance + 1);
        dfs(grid, i, j + 1, visited, currDistance + 1);
        dfs(grid, i + 1, j, visited, currDistance + 1);
        dfs(grid, i - 1, j, visited, currDistance + 1);
        visited[i][j] = false;
    }

}

