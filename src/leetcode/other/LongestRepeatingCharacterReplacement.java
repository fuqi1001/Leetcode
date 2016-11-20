package leetcode.other;

/**
 * Created by qifu on 16/10/25.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0) return 0;
        char[] ctr = s.toCharArray();

        int res = 0;
        for(int i = 0 ; i <26 ;i++){
            res = Math.max(res,helper(ctr,k,n,(char)('A' + i)));
        }
        return res;
    }
    private int helper(char[] ctr, int k, int n, char valid){
        int start = 0;
        int end = 0;
        int res = 0;
        int usedK = 0;
        while(end < n){
            if(ctr[end] == valid || usedK < k){
                if(ctr[end] != valid){
                    usedK++;
                }
                res = Math.max(res, end - start + 1);
                end++;
            }else{
                if(ctr[start] != valid)
                    usedK--;
                start++;
            }
        }
        return res;
    }
}
