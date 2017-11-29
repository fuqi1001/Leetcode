package z_leetcode.bloomberg_onsite;

public class DateOfBirth {

    /**
     * 给一批人的Year-of-birth, year-of-dead
     求在哪一年中活着的人数最多.
     * @param dob
     * @param period
     * @return
     */
    public int most(int[][] dob, int period) {
        int[] count = new int[period];
        for(int[] cur : dob) {
            int start = cur[0], end = cur[1];
            count[start] += 1;
            if(end < period - 1) count[end + 1] -= 1;
        }

        int sum = 0;
        int max = 0;
        for(int i = 0; i < period ; i++) {
            sum += count[i];
            count[i] = sum;
            max = Math.max(count[i], max);
        }
        return max;
    }
}
