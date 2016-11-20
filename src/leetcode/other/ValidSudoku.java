package leetcode.other;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by qifu on 16/9/15.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        //row

        for(int i = 0 ; i < 9 ; i++){
            Arrays.fill(visited,false);
            for(int j = 0 ; j < 9 ; j++){
                if(!helper(visited,board[i][j])) return false;
            }
        }

        //col
        for(int i = 0 ; i < 9 ; i++){
            Arrays.fill(visited,false);
            for(int j = 0 ; j < 9 ;j++){
                if(!helper(visited,board[j][i])) return false;
            }
        }

        //sub matrix
        for(int i = 0 ; i < 9 ;i += 3){
            for(int j = 0 ; j < 9 ; j += 3){
                Arrays.fill(visited,false);
                for(int k = 0 ; k < 9 ;k++){
                    if(!helper(visited,board[i+k/3][j+k%3])) return false;
                }
            }
        }
        return true;
    }

    public boolean helper(boolean[] visited, char c){
        if(c == '.') return true;

        int num = c - '0';

        if(visited[num - 1] || num < 1 || num > 9) return false;
        visited[num - 1] = true;
        return true;
    }
}
