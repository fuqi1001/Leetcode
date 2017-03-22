package leetcode.other;

/**
 * Created by qifu on 17/3/22.
 */
public class DesignTicTacToe {
    //O(1)
    int[] rows;
    int[] cols;
    int d;
    int anti_d;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int cur_move = player == 1 ? 1 : -1;
        rows[row] += cur_move;
        cols[col] += cur_move;
        if(row == col)
            d += cur_move;
        if(col == rows.length - 1 - row)
            anti_d += cur_move;
        int size = rows.length;
        if(Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(d) == size || Math.abs(anti_d) == size) {
            return player;
        }
        return 0;
    }
}
