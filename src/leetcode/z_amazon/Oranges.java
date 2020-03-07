package leetcode.z_amazon;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int countFresh = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) countFresh++;
            }
        }
        if (countFresh == 0) return 0;
        int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int count = 0;
        while(!que.isEmpty()) {
            ++count;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int[] curr = que.poll();
                for(int[] dir: direction) {
                    int nextX = curr[0] + dir[0];
                    int nextY = curr[1] + dir[1];
                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || grid[nextX][nextY] != 1) continue;
                    grid[nextX][nextY] = 2;
                    que.offer(new int[]{nextX, nextY});
                    countFresh--;
                }
            }
        }
        return countFresh == 0 ? count - 1 : -1;
    }
}

class Main {
    // Time O(r * c) and space - O(1)
    public static int distributeFiles(int[][] servers){
        if(servers == null || servers.length == 0){
            return -1;
        }
        int days = 0;
        int r = servers.length;
        int c = servers[0].length;
        int conn = 0;
        int clusterSize = r * c;
        final int[][] movements = {{0,-1},{0,1},{-1,0},{1,0}};
        Queue<Position> places = new ArrayDeque<Position>();
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(servers[i][j] == 1){
                    conn += 1;//server is already having file
                    places.add(new Position(i,j));
                }
            }
        }
        while(!places.isEmpty()){
            if(conn == clusterSize){
                return days;
            }
            for(int i = 0;i<places.size();i++){
                Position p = places.poll();
                int currentX = p.getX();
                int currentY = p.getY();
                servers[currentX][currentY] = 1;
                for(int[] m:movements){
                    int newX = currentX + m[0];
                    int newY = currentY + m[1];
                    Position t = new Position(newX,newY);
                    if(t.isPositionSafe(servers.length,servers[0].length) && servers[newX][newY] == 0){
                        places.add(t);
                        servers[newX][newY] = 1;
                        conn++;
                    }
                }
            }
            days++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0 }
        };
        System.out.println(distributeFiles(grid));
    }
}


class Position{
    int x;
    int y;
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean isPositionSafe(int x,int y){
        return (this.x>=0 && this.x<x && this.y>=0 && this.y<y);
    }
}