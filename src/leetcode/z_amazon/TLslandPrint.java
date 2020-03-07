package leetcode.z_amazon;

import java.util.*;

public class TLslandPrint {
    public List<int[]> shortestPathToTreasureIsland(char grid[][]) {

        if (grid == null || grid.length == 0)
            return Collections.EMPTY_LIST;


        return shortestPath(grid);

    }


    private List<int[]> shortestPath(char[][] grid) {


        int n = grid.length;
        int m = grid[0].length;

        final int row[] = {0, 0, 1, -1};
        final int col[] = {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        /**
         * Coordinates and distance
         */
        queue.offer(new int[]{0, 0, 0});

        /**
         * This hold the distance which been cover by the path
         */
        int distance[][] = new int[n][m];

        /**
         * Assume you can't reach anywhere
         */
        for (int i = 0; i < n; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);

        /**
         * Distance from source is always 0
         */
        distance[0][0] = 0;

        /**
         * Holds the treasure location
         */
        int treasure[] = new int[]{-1, -1};

        int minDistance = 0;

        while (!queue.isEmpty()) {

            int[] cord = queue.poll();

            int i = cord[0];
            int j = cord[1];
            int d = cord[2];
            distance[i][j] = d;


            for (int k = 0; k < row.length; k++) {

                int r = row[k] + i;
                int c = col[k] + j;

                if (isSafe(r, c, n, m, grid, 'D')) {

                    /**
                     * Treasure found
                     */
                    if (grid[r][c] == 'X') {
                        minDistance = d + 1;
                        treasure[0] = r;
                        treasure[1] = c;
                        break;
                    }

                    grid[r][c] = 'D';
                    queue.offer(new int[]{r, c, d + 1});
                }
            }


        }

        return buildPath(distance, treasure, row, col);
    }

    /**
     * Back track and find the path from treasure to source
     *
     * @param distance
     * @param treasure
     * @param row
     * @param col
     * @return
     */
    private List<int[]> buildPath(int distance[][], int[] treasure, final int row[], final int col[]) {
        List<int[]> path = new ArrayList<>();

        int i = treasure[0];
        int j = treasure[1];

        while (true) {

            path.add(new int[]{i, j});
            int d = Integer.MAX_VALUE;
            int x = i, y = j; //Will tell from where we reached i and j

            /**
             * Find the location from where we reach here;
             * which gives minimum distance
             */
            for (int k = 0; k < row.length; k++) {

                int r = row[k] + i;
                int c = col[k] + j;


                if (isInBoundary(r, c, distance.length, distance[0].length)) {

                    if (d > distance[r][c]) {
                        d = distance[r][c];
                        x = r;
                        y = c;
                    }
                }
            }

            /**
             * If we have reached source back
             */
            if (x == 0 && y == 0) {
                path.add(new int[]{0, 0});
                break;
            }


            i = x;
            j = y;

        }
        Collections.reverse(path);
        return path;

    }

    private boolean isInBoundary(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }

    private boolean isSafe(int r, int c, int n, int m, char[][] grid, char danger) {
        if (isInBoundary(r, c, n, m) && grid[r][c] != danger)
            return true;
        return false;
    }
}

