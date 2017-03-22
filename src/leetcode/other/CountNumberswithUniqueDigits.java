package leetcode.other;

/**
 * Created by qifu on 17/3/22.
 */
public class CountNumberswithUniqueDigits {
    //dp
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int res = 10;       //0~9
        int unique = 9;
        int available = 9;      //can be choose
        while(n-- > 1 && available > 0) {
            unique = unique * available;
            res += unique;
            available--;
        }
        return res;
    }

    //backtracking
    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10) return countNumbersWithUniqueDigits(10);

        long max = (long)Math.pow(10, n);
        boolean[] used = new boolean[10];
        int count = 1;
        for(int i = 1; i <= 9; i++) {
            used[i] = true;
            count += helper(i, max, used);
            used[i] = false;
        }
        return count;
    }
    private  int helper(long prev, long max, boolean[] used) {
        int count = 0;
        if(prev < max) {
            count += 1;
        } else {
            return count;
        }
        for(int i = 0; i <= 9; i++) {
            if(!used[i]) {
                used[i] = true;
                long cur = 10 * prev + i;
                count += helper(cur, max, used);
                used[i] = false;
            }
        }
        return count;
    }
}
