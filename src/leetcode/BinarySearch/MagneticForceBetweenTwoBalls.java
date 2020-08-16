package leetcode.BinarySearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    /**
     * In universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
     *
     * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
     *
     * Given the integer array position and the integer m. Return the required force.
     *
     * https://leetcode.com/problems/magnetic-force-between-two-balls/
     */

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int len = position.length;

        int left = 0, right = (position[len - 1] - position[0]) / (m - 1); // m ball, need (m - 1) gap

        while(left <= right) {
            int distance = left + (right - left) / 2;
            int count = countCanFit(position, distance);
            if (count >= m - 1) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return right;
    }

    private int countCanFit(int[] position, int distance) {
        int prevIdx = 0;
        int count = 0;
        for(int i = 1; i < position.length; i++) {
            if (position[i] - position[prevIdx] >= distance) {
                prevIdx = i;
                count++;
            }
        }
        return count;
    }

}
