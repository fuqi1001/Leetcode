package leetcode.Tree;

/**
 * Created by qifu on 17/3/25.
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num == 6 || num == 28 || num == 496 ||num ==  8128 || num == 33550336) return true;
        else return false;
    }
    //
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i=2;i<Math.sqrt(num);i++)
            if (num % i == 0) sum += i + (num/i);
        return num != 1 && sum == num;
    }
}
