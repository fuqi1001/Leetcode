package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/2/7.
 */
public class TheMazeII {

    ///// BFS
    int[][] dir = {
            {1,0}, {-1, 0}, {0,1}, {0,-1}
    };
    private int diff(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    private boolean isValid(int x, int y, int[][] maze){
        if((x >= 0 && x < maze.length) && (y >= 0 && y < maze[0].length) && maze[x][y] == 0) return true;
        return false;
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || start == null || destination == null)  return -1;
        int row = maze.length;
        int col = maze[0].length;

        int[][] distance = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> points = new LinkedList<>();


        points.add(start);
        distance[start[0]][start[1]] = 0;

        while(!points.isEmpty()){
            int[] cur_point = points.poll();
            for(int i = 0; i < 4; i++){
                int next_x = cur_point[0];
                int next_y = cur_point[1];
                while(isValid(next_x + dir[i][0], next_y + dir[i][1], maze)){
                    next_x += dir[i][0];
                    next_y += dir[i][1];
                }

                if(distance[next_x][next_y] > distance[cur_point[0]][cur_point[1]] + diff(next_x,next_y, cur_point[0],cur_point[1])){
                    distance[next_x][next_y] = distance[cur_point[0]][cur_point[1]] + diff(next_x,next_y, cur_point[0],cur_point[1]);
                    int[] next_point = {next_x, next_y};
                    points.add(next_point);
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    /////DFS

    int[][] dir = {
            {1,0}, {-1, 0}, {0,1}, {0,-1}
    };
    private int diff(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    private boolean isValid(int x, int y, int[][] maze){
        if((x >= 0 && x < maze.length) && (y >= 0 && y < maze[0].length) && maze[x][y] == 0) return true;
        return false;
    }
    private void dfs(int[][] maze, int[][] distance, int[] cur,  int[] destination){
        if(cur[0] == destination[0] && cur[1] == destination[1]) return;
        for(int i = 0; i < 4; i++){
            int next_x = cur[0];
            int next_y = cur[1];
            while(isValid(next_x + dir[i][0], next_y + dir[i][1], maze)){
                next_x += dir[i][0];
                next_y += dir[i][1];
            }

            if(distance[next_x][next_y] > distance[cur[0]][cur[1]] + diff(next_x, next_y, cur[0], cur[1])){
                distance[next_x][next_y] = distance[cur[0]][cur[1]] + diff(next_x, next_y, cur[0], cur[1]);
                int[] next_point = {next_x, next_y};
                dfs(maze, distance, next_point, destination);
            }
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || start == null || destination == null) return -1;

        int row = maze.length;
        int col = maze[0].length;

        int[][] distance = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, distance, start, destination);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
