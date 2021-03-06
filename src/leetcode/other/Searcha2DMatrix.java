package leetcode.other;

/**
 * Created by qifu on 16/10/19.
 */
public class Searcha2DMatrix {


    //
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        if(matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0, end = row * col - 1;
        while(start + 1< end) {
            int mid = start + (end - start) / 2;
            int number = matrix[mid/col][mid%col];
            if(number == target) return true;
            if(number < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(matrix[start/col][start%col] == target) return true;
        if(matrix[end/col][end%col] == target) return true;
        return false;
    }

    //
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        //find line
        int start = 0;
        int end = matrix.length - 1;


        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(matrix[end][0] <= target){
            start = end;
        }else if(matrix[start][0] <= target){
            start = start;
        }else{
            return false;
        }

        int left = 0;
        int right = matrix[0].length - 1;

        while(left + 1 < right){

            int mid = left + (right - left)/2;
            if(matrix[start][mid] == target) return true;
            else if(matrix[start][mid] < target) left = mid;
            else right = mid;
        }

        if(matrix[start][left] == target) return true;
        else if(matrix[start][right] == target) return true;
        return false;
    }
    //
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) {
                row++;
            } else if(matrix[row][col] > target) {
                col--;
            }
        }
        return false;
    }
}
