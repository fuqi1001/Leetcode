package leetcode.other;

/**
 * Created by qifu on 17/4/10.
 */
public class SudokuSolver {
    //shorter
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        helper(board);
    }
    public boolean helper(char[][] board) {
        int len = board.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == c && i != col) return false;
            if(board[i][col] == c && i != row) return false;
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }


    //
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    private boolean helper(char[][] board, int row, int col) {
        if(row == 9) return true;
        int next_row = 0;
        int next_col = 0;
        if(col == 8) {
            next_row = row + 1;
            next_col = 0;
        } else {
            next_row = row;
            next_col = col + 1;
        }
        if(board[row][col] != '.') {
            if(!isValid(board,row,col)) return false;
            return helper(board,next_row,next_col);
        }
        for(char i = '1'; i <= '9'; i++) {
            board[row][col] = i;
            if(isValid(board,row,col) && helper(board, next_row,next_col)) return true;
            board[row][col] = '.';
        }
        return false;
    }
    private boolean isValid(char[][] board, int row, int col) {
        char cur = board[row][col];
        if(cur-'0' < 0 || cur-'0' > 9) return false;

        for(int i = 0; i < 9; i++) {
            if(board[i][col] == cur && i != row) return false;
            if(board[row][i] == cur && i != col) return false;
        }
        int temp_row = row/3 * 3;   //可以找到每个子matrix的起始位置
        int temp_col = col/3 * 3;
        for(int i = temp_row; i < temp_row + 3; i++) {
            for(int j = temp_col; j < temp_col + 3; j++) {
                if(board[i][j] == cur && (i!=row && j != col)) return false;
            }
        }
        return true;
    }
}
