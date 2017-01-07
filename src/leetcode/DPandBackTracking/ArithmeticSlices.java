package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/1/7.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A){
        int sum = 0;
        int cur = 0;
        for(int i = 2; i < A.length ;i++){
            if(A[i - 1] - A[i] == A[i - 2] - A[i - 1]){
                cur++;
                sum += cur;
            }
            else {
                cur = 0;
            }
        }
        return sum;
    }
}
