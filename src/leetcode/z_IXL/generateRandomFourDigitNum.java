package leetcode.z_IXL;

import java.util.Random;

/**
 * Created by qifu on 17/4/22.
 */
public class generateRandomFourDigitNum {
    //iterative
    public int getRan(int digit) {
        int[] nums = new int[digit];
        int first = 0;
        while(first == 0) {
            first = (int)(Math.random() * 10);
        }
        nums[0] = first;

        for(int i = 1; i < digit;i ++) {
            int cur = (int)(Math.random() * 10) ;

            while(cur == nums[i - 1] || i == digit - 1 && cur % 2 != 0) {
                cur = (int)(Math.random() * 10);
            }
            nums[i] = cur;
        }
        int res = 0;
        int mul = 1;
        for(int i = digit - 1; i >= 0; i--) {
            res += mul * nums[i];
            mul *= 10;
        }
        return res;
    }
    ///recursion
    public int nonRepeatingDigits(int digits) {
        if(digits <= 0) {
            return 0;
        }
        int[] result = new int[1];
        int prev = 10;
        dfs(result, 0, digits, prev);
        return result[0];
    }
    public void dfs(int[] result, int level, int digits, int prev) {
        if(level == digits) {
            return;
        }
        Random generator = new Random();
        int random = generator.nextInt(10);
        while(random == prev || random == 0 && level == 0 || random % 2 != 0 && level == digits - 1) {
            random = generator.nextInt(10);
        }
        result[0] = result[0] * 10 + random;
        dfs(result, level + 1, digits, random);
    }

    /*
    1. generate the digit,
        if it is the first level, the digit can't be zero
    2. make sure the digit are not the same as prev one
    3. recursion
     */


}
