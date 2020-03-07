package leetcode.z_amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *  In my thought,
 *  we can sort forwardRouteList and returnRouteList by its second element as first.
 *  What we really care is the sum of route dist
 *  must be smaller than maxTravelDist and as large as possible.
 *  We can set two pointers and traverse two sorted arrays to find the max value
 *  (and the combination of course).
 *  Since the sorting part complexity is O(MlogM + NlogN) and two-pointer traversal is O(M + N),
 *  the final complexity can be regarded as O(KlogK) where K is the longest input array.
 */
class OptimalUtilization {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        // O(n^2), Space(logn)
//        Collections.sort(a, (i, j) -> i[1] - j[1]);
//        Collections.sort(b, (i, j) -> i[1] - j[1]);
        // sort this two collections to asec rank
        // sorting the array helps us to void unnecessary comparisons. This is an optimization strategy.
        Collections.sort(a, Comparator.comparingInt(i -> i[1]));
        Collections.sort(b, Comparator.comparingInt(i -> i[1]));

        List<int[]> result = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        int m = a.size();
        int n = b.size();
        int i = 0, j = n - 1;
        // for a start from head, b start from tail
        while(i < m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum > target) {
                j--;
            } else {
                if (max <= sum) {
                    max = sum;
                    result.clear(); // clear all prev result, because find a smaller[more close one]
                }
                result.add(new int[]{a.get(i)[0], b.get(j)[0]}); // add new res to result list;
                int index= j - 1;
                while(index >= 0 && b.get(index)[1] == b.get(index + 1)[1]) {
                    result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    // find same value with b.get(j)[1]; append them to result;
                }
                i++;
            }
        }
        return result;
    }
}
