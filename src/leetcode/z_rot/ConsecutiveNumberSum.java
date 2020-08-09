package leetcode.z_rot;

public class ConsecutiveNumberSum {
    public int consecutiveNumbersSum(int N) {
        /**
         N = (x + 1) + (x + 2) + ... + (x + k)
         to
         N - (1 + 2 + ... + k) = k * x;
         */
        int count = 0;
        for(int k = 1; ;k++) {
            N -= k;
            if (N < 0) break;
            if (N % k == 0) count++;
        }
        return count;
    }
}
