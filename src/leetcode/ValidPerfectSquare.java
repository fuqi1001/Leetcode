package leetcode;

/**
 * Created by qifu on 16/10/20.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num){
        if(num == 1 ||num == 4) return true;

        long left = 1;
        long right = num / 2 - 1;
        while(left <= right){
            long mid = left +((right - left ) / 2);
            long mul = mid*mid;
            if(mul == num) return true;
            else if(mul > num) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}
