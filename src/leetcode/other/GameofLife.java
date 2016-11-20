package leetcode.other;

/**
 * Created by qifu on 16/10/24.
 */
public class GameofLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0) return;

        int m = board.length;
        int n = board[0].length;

        int[][] temp = new int[m][n];


        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ;j++){
                temp[i][j] = 0;
                int count = countNeighbors(board,i,j);
                if(board[i][j] == 1){
                    if(count == 2 || count == 3) {
                        System.out.println("x: "+i +" y: "+j + " run 1 ");
                        temp[i][j] = 1;
                    }
                    else if(count > 3) {
                        System.out.println("x: "+i +" y: "+j +" run 2" );
                        temp[i][j] = 0;
                    }
                    else{
                        System.out.println("x: "+i +" y: "+j +" run 3");
                        temp[i][j] = 0;
                    }
                }else if(board[i][j] == 0){

                    if(count == 3) {
                        System.out.println("x: "+i +" y: "+j +" run 4");
                        temp[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ;j++){
                board[i][j] = temp[i][j];
            }
        }

    }
    public int countNeighbors(int[][] board, int x,int y){
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {1,0,-1,1,-1,1,0,-1};
        for(int i = 0 ; i < 8 ;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >=m || ny>=n) continue;
            if(board[nx][ny] == 1) {
                count++;
            }
        }
        return count;

    }
}
