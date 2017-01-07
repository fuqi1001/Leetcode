package leetcode.other;

/**
 * Created by qifu on 17/1/7.
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates){
        int[] res = new int[length];

        for(int[] move : updates){
            int start = move[0];
            int end = move[1];
            int value = move[2];

            res[start] += value;
            if(end < length - 1){
                res[end + 1] -= value;
            }
        }

        int sum = 0;
        for(int i = 0 ; i < res.length; i++){
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
