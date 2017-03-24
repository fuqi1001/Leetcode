package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/3/24.
 */
public class WallsandGates {
    //dfs
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }
    public void dfs(int[][] rooms, int x, int y, int dis) {
        if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < dis) return ;
        rooms[x][y] = dis;
        dfs(rooms, x - 1, y, dis + 1);
        dfs(rooms, x + 1, y, dis + 1);
        dfs(rooms, x, y - 1, dis + 1);
        dfs(rooms, x, y + 1, dis + 1);
    }

    //bfs
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if(x > 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
                rooms[x - 1][y] = rooms[x][y] + 1;
                queue.add(new int[] {x - 1, y});
            }
            if(x < rooms.length - 1 && rooms[x + 1][y] == Integer.MAX_VALUE) {
                rooms[x + 1][y] = rooms[x][y] + 1;
                queue.add(new int[] {x + 1, y});
            }
            if(y > 0 && rooms[x][y - 1] == Integer.MAX_VALUE) {
                rooms[x][y - 1] = rooms[x][y] + 1;
                queue.add(new int[] {x, y - 1});
            }
            if(y < rooms[0].length - 1 && rooms[x][y + 1] == Integer.MAX_VALUE) {
                rooms[x][y + 1] = rooms[x][y] + 1;
                queue.add(new int[] {x, y + 1});
            }
        }
    }
}
