package leetcode.other;

/**
 * Created by qifu on 17/2/13.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if( helper(board, i, j, words, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int x, int y, char[] words, int i){
        if(i == words.length) return true;

        if(x < 0 || y < 0 || x == board.length || y == board[0].length) return false;
        if(words[i] != board[x][y]) return false;

        board[x][y] ^= 256;
        boolean res = helper(board, x + 1, y, words, i + 1)
                ||helper(board, x - 1, y, words, i + 1)
                ||helper(board, x, y + 1, words, i + 1)
                ||helper(board, x, y - 1, words, i + 1);
        board[x][y] ^= 256;
        return res;
    }
}
