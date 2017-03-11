package leetcode.other;

/**
 * Created by qifu on 17/3/11.
 */
public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        return helper(1, n);
    }
    private int helper(int start, int end) {
        if(start > end) return -1;
        if(guess(start)==0) return start;
        if(guess(end)==0) return end;
        int mid = start + (end - start) / 2;
        if(guess(mid) == 0) return mid;
        else if(guess(mid) == -1) return helper(start + 1, mid - 1);
        else return helper(mid + 1, end - 1);
    }
}
