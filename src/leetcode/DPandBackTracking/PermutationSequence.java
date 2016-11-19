package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by qifu on 16/11/19.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] facotrial = new int[n + 1];
        int f = 1;
        facotrial[0] = 1;
        for(int i = 1; i <= n ; i++){
            f *= i;
            facotrial[i] = f;
            nums.add(i);
        }

        return dfs(new StringBuilder(), nums, facotrial, n, k - 1);
    }

    private String dfs(StringBuilder sb, List<Integer> nums, int[] f, int n, int k){
        if(nums.size() == 0) return sb.toString();
        int i = k / f[n-1];
        sb.append(nums.get(i));
        nums.remove(i);
        return dfs(sb, nums,  f, n - 1, k - i * f[n - 1]);
    }

    ///https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n

    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }
}
