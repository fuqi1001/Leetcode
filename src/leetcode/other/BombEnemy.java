package leetcode.other;

/**
 * Created by qifu on 17/2/3.
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length < 1) return 0;
        int res = 0;

        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0 ; i < row; i++){
            for(int j = 0 ; j < col; j++){
                if(grid[i][j] == '0'){
                    int sum = 0;
                    //run to left
                    int left = j;
                    while(left > 0 && grid[i][--left] != 'W'){
                        if(grid[i][left] == 'E'){
                            sum++;
                        }
                    }
                    //run to right
                    int right = j;
                    while(right < col - 1 && grid[i][++right] != 'W'){
                        if(grid[i][right] == 'E'){
                            sum++;
                        }
                    }

                    //run to top
                    int top = i;
                    while(top > 0 && grid[--top][j] != 'W'){
                        if(grid[top][j] == 'E'){
                            sum++;
                        }
                    }

                    //run to bottom
                    int bottom = i;
                    while(bottom < row - 1 && grid[++bottom][j] != 'W'){
                        if(grid[bottom][j] == 'E'){
                            sum++;
                        }
                    }

                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }


    ///
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length < 1) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        int[][] dp = new int[row][col];

        //for row
        for(int i = 0 ; i < row; i++){
            //from left to right
            int cnt = 0;
            for(int k = 0; k < col; k++){
                if(grid[i][k] == '0'){
                    dp[i][k] = cnt;
                } else if(grid[i][k] == 'E'){
                    cnt++;
                } else {
                    cnt = 0;
                }
            }

            //from right to left
            cnt = 0;
            for(int k = col - 1; k >= 0; k--){
                if(grid[i][k] == '0'){
                    dp[i][k] += cnt;
                } else if(grid[i][k] == 'E') {
                    cnt++;
                } else {
                    cnt = 0;
                }
            }
        }

        //for col
        for(int i = 0; i < col; i++){
            //from top to bot
            int cnt = 0;
            for(int k = 0; k < row; k++){
                if(grid[k][i] == '0'){
                    dp[k][i] += cnt;
                } else if(grid[k][i] == 'E'){
                    cnt++;
                } else {
                    cnt = 0;
                }
            }

            //from bot to top
            cnt = 0;
            for(int k = row - 1; k >= 0; k--){
                if(grid[k][i] == '0'){
                    dp[k][i] += cnt;
                    res = Math.max(res, dp[k][i]);
                } else if(grid[k][i] == 'E'){
                    cnt++;
                } else {
                    cnt = 0;
                }
            }
        }
        return res;
    }
}
