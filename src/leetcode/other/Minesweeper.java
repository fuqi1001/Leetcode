package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/3/16.
 */
public class Minesweeper {
    //dfs
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;

        int row = click[0];
        int col = click[1];
        if(board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    if(i == 0 && j == 0) continue;
                    int r = row + i;
                    int c = col + j;
                    if(r < 0 || r >= m || c < 0 || c >= n) continue;
                    if(board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }

            if(count > 0) {
                board[row][col] = (char)(count + '0');
            } else {
                board[row][col] = 'B';
                for(int i = -1; i <= 1; i++) {
                    for(int j = -1; j <= 1; j++){
                        if(i == 0 && j == 0) continue;
                        int r = row + i;
                        int c = col + j;
                        if(r < 0 || r >= m || c < 0 || c >= n) continue;
                        if(board[r][c] == 'E') updateBoard(board, new int[] {r,c});
                    }
                }
            }
        }
        return board;
    }

    //bfs
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> move = new LinkedList<>();
        move.add(click);
        while(!move.isEmpty()) {
            int[] cur = move.poll();
            int row = cur[0];
            int col = cur[1];
            if(board[row][col] == 'M') {
                board[row][col] = 'X';
            }
            else {
                int count = 0;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        if(i == 0 && j == 0) continue;
                        int r = row + i;
                        int c = col + j;
                        if(r < 0 || r >= m || c < 0 || c >= n) continue;
                        if(board[r][c] == 'M' || board[r][c] == 'X') count++;
                    }
                }
                if(count > 0) {
                    board[row][col] = (char)(count + '0');
                } else {
                    board[row][col] = 'B';
                    for(int i = -1; i <= 1; i++) {
                        for(int j = -1; j <= 1; j++) {
                            if(i == 0 && j == 0) continue;
                            int r = row + i;
                            int c = col + j;
                            if(r < 0 || r >= m || c < 0 || c >= n) continue;
                            if(board[r][c] == 'E') {
                                move.add(new int[] {r, c});
                                board[r][c] = 'B';
                            }

                        }
                    }
                }
            }
        }
        return board;
    }
}
