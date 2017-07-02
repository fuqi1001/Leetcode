package leetcode.other;

/**
 * Created by qifu on 17/7/1.
 */
public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if(c == 1 || c == 0) return true;
        int mid = (int)Math.sqrt(c);
        int left = 0, right = mid;
        while(left <= right) {
            int temp = left * left + right * right;
            if(temp == c) return true;
            else if(temp < c) left++;
            else if(temp > c) right--;
        }
        return false;
    }
}
