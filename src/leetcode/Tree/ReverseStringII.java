package leetcode.Tree;

/**
 * Created by qifu on 17/3/11.
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if(k == 0 || s.length() == 0) return s;
        int count = s.length();
        char[] ctr = s.toCharArray();

        for(int i = 0 ; i < s.length(); ) {
            if(count >= 2 * k) {
                //System.out.println("1");
                helper(ctr, i, i + k - 1);
            } else if(count < 2 * k && count >= k) {
                helper(ctr, i, i + k - 1);
            } else if(count < k){
                helper(ctr, i, s.length()-1);
            }
            i += 2 * k;
            count -= 2 * k;
        }
        return new String(ctr);
    }
    public void helper(char[] ctr, int start, int end) {
        while(start < end) {
            char temp = ctr[start];
            ctr[start] = ctr[end];
            ctr[end] = temp;
            start++;
            end--;
        }
    }
}
