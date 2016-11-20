package leetcode.other;

/**
 * Created by qifu on 16/9/6.
 */
public class AddDigits {
    public int addDigits(int num) {
        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        else{
            return num % 9;
        }
    }

    //https://discuss.leetcode.com/topic/52727/2ms-one-line-java-solution/3
    /*
    0~9 (10 nums) :      0,1,2,3,4,5,6,7,8,9
    10~18(9 nums):         1,2,3,4,5,6,7,8,9
    19~27(9 nums):         1,2,3,4,5,6,7,8,9
    and so on
     */
}
