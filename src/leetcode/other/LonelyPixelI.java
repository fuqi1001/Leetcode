package leetcode.other;

/**
 * Created by qifu on 17/3/4.
 */
public class LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {
        if(picture == null) return 0;
        int row = picture.length;
        int col = picture[0].length;
        int[] count_row = new int[row];
        int[] count_col = new int[col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(picture[i][j] == 'B'){
                    count_row[i]++;
                    count_col[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                if(picture[i][j] == 'B' && count_row[i] == 1 && count_col[j] == 1) count++;
            }
        }
        return count;
    }
}
