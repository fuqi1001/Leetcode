package leetcode;

/**
 * Created by qifu on 16/9/6.
 */
public class ProductOfArrayExceptSelf {
    //http://blog.csdn.net/wzy_1988/article/details/46916179
    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];

        result[0] = 1; // important
        int p = 1;

        for(int i = 1; i < nums.length ;i++){
            p = p * nums[i - 1];
            result[i] = p;
        }

        p = 1;
        for(int i = nums.length - 2; i >= 0 ; i--){
            p = p * nums[i + 1];
            result[i] *= p;
        }
        return result;
    }



}
