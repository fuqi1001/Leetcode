package leetcode.Tree;

/**
 * Created by qifu on 17/2/23.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, char[] words, int x, int y, int num){
        if(num == words.length) return true;
        if(x < 0 || y < 0 || x == board.length || y == board[0].length) return false;
        if(board[x][y] != words[num]) return false;

        board[x][y] ^= 256;
        boolean exist = helper(board, words, x, y+1,num + 1)
                || helper(board, words, x, y-1,num + 1)
                || helper(board, words, x+1, y,num + 1)
                || helper(board, words, x-1, y,num + 1);
        board[x][y] ^= 256;
        return exist;
    }
}
