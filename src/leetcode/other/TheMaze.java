package leetcode.other;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/2/7.
 */
public class TheMaze {

    ///BFS
    private boolean isValid(int x, int y, int[][] maze) {
        int row = maze.length;
        int col = maze[0].length;
        if((x >= 0 && x < row) && (y >= 0 && y < col) && maze[x][y] == 0) return true;
        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || start == null || destination == null) return false;
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> point = new LinkedList<>();

        int[][] dir = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        visited[start[0]][start[1]] = true;
        point.add(start);

        while(!point.isEmpty()){
            int[] cur_point = point.poll();
            for(int i = 0 ; i < 4; i++){
                int next_x = cur_point[0];
                int next_y = cur_point[1];
                while(isValid(next_x + dir[i][0], next_y + dir[i][1], maze)){
                    next_x +=  dir[i][0];
                    next_y +=  dir[i][1];
                }
                if(next_x == destination[0] && next_y == destination[1]) return true;

                if(!visited[next_x][next_y]){
                    visited[next_x][next_y] = true;
                    int[] next_point = {next_x,next_y};
                    point.add(next_point);
                }
            }
        }
        return false;
    }


    ///DFS

    private boolean isValid(int x, int y, int[][] maze){
        if((x >= 0 && x < maze.length) && (y >= 0 && y < maze[0].length) && maze[x][y] == 0){
            return true;
        }
        return false;
    }

    private boolean dfs(int[][] maze, boolean[][] visited, int[] cur, int[] destination){
        if(cur[0] == destination[0] && cur[1] == destination[1]) return true;
        else if(visited[cur[0]][cur[1]] == true) return false;

        visited[cur[0]][cur[1]] = true;

        int[][] dir = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        for(int i = 0; i < 4; i++){
            int next_x = cur[0];
            int next_y = cur[1];
            while(isValid(next_x + dir[i][0],next_y + dir[i][1], maze)){
                next_x += dir[i][0];
                next_y += dir[i][1];
            }
            int[] next_point = {next_x, next_y};
            if(dfs(maze,visited,next_point,destination)) return true;
        }
        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || start == null || destination == null) return false;

        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        return dfs(maze, visited, start, destination);
    }
}
