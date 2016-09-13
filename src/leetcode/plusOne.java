package leetcode;

/**
 * Created by qifu on 16/9/13.
 */
public class plusOne {
    public int[] plusOne(int[] digits){
        int carries = 1;
        for(int i = digits.length - 1; i >= 0 ; i--){
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }

        if(carries == 0){
            return digits;
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;
        for(int i = 1; i < result.length ; i++){
            result[i] = digits[i-1];
        }
        return result;
    }
}
