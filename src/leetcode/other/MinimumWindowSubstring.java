package leetcode.other;

/**
 * Created by qifu on 17/1/2.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(char c : t.toCharArray()){
            hash[c]++;
        }
        int counter = t.length();
        int left = 0;
        int right = 0;
        int d = Integer.MAX_VALUE;
        int head = 0;

        while(right < s.length()){
            /*if(hash[s.charAt(right++)]-- > 0) counter--;
            while(counter == 0){
                if(right - left < d) {
                    d = right - left;
                    head = left;
                }

                if(hash[s.charAt(left++)]++ == 0) counter++;
            }*/

            if(hash[s.charAt(right)] > 0) counter--;
            hash[s.charAt(right)]--;
            right++;

            while(counter == 0){
                if(right - left < d){
                    head = left;
                    d = right - left;
                }

                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0) counter++;
                left++;
            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
