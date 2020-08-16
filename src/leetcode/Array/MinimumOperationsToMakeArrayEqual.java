package leetcode.Array;

public class MinimumOperationsToMakeArrayEqual {
    /**
     * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
     *
     * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is guaranteed that all the elements of the array can be made equal using some operations.
     *
     * Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.
     */

    public int minOperations(int n) {
        int mid = n / 2;
        if (n % 2 != 0) {
            int cnt = 0;
            int midNum = getNum(mid);
            for (int i = 0; i < mid; i++) {
                int curNum = getNum(i);
                cnt += midNum - curNum;
            }
            return cnt;
        } else {
            int cnt = 1;
            int midNum = getNum(mid - 1) + 1;

            for(int i = 0; i < mid - 1; i++) {
                int curNum = getNum(i);
                cnt += midNum - curNum;
            }
            return cnt;
        }

    }
    private int getNum(int num) {
        return num * 2 + 1;
    }
}
