package leetcode.other;

/**
 * Created by qifu on 16/10/24.
 */
public class GameofLife {

    //in place
    /*
    用两位bits来存
    00 -> 表示原来是死的,操作完后也是死的
    01 -> 表示原来是活的,操作完后是死的
    11 -> 表示原来是获得,操作完后也是活的
    10 -> 表示原来是死的,操作完后变成活的
    第一位表示原来,第二位表示现在
     */

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = countN(board, i,j);

                if(board[i][j] == 1) {
                    if(count >= 2 && count <= 3) {
                        board[i][j] = 3;  //11
                    }
                }
                else if(board[i][j] == 0){
                    if(count == 3) {
                        board[i][j] = 2;
                    }
                }

            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    private int countN(int[][] board, int x, int y) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) continue;
                if(x + i < 0 || x + i >= m || y + j < 0 || y + j >= n) continue;
                if( (board[x + i][y + j] & 1 )== 1) count++;
            }
        }
        return count;
    }

    //
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;

        int[][] temp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = countN(board, i,j);
                //System.out.println(count);
                if(board[i][j] == 1) {
                    if(count < 2 || count > 3) {
                        temp[i][j] = 0;
                    } else {
                        temp[i][j] = 1;
                    }
                } else if(board[i][j] == 0){
                    if(count == 3) {
                        temp[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
    private int countN(int[][] board, int x, int y) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) continue;
                if(x + i < 0 || x + i >= m || y + j < 0 || y + j >= n) continue;
                if(board[x + i][y + j] == 1) count++;
            }
        }
        return count;
    }
}
