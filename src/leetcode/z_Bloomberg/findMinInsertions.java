package leetcode.z_Bloomberg;

public class findMinInsertions {
    public static int findMin(String str) {
       return helper(str.toCharArray(), 0, str.length() - 1);
    }
    public static int helper(char[] str, int left , int right) {
       if(left > right) return Integer.MAX_VALUE;
       if(left == right) return 0;
       if(left == right - 1) return (str[left] == str[right]) ? 0 : 1;

       return (str[left] == str[right]) ?
               helper(str, left+1, right-1):
               (Integer.min(helper(str,left, right - 1),
                       helper(str, left + 1, right)) + 1);
    }

    public static void main(String[] args) {
        String str = "geeks";
        System.out.println(findMin(str));
        System.out.println(helper_dp(str.toCharArray()));
    }

    public static int helper_dp(char[] str) {
        int len = str.length;
        int[][] table = new int[len][len];
        int left, right, gap;
        right = 0;
        for(gap = 1; gap < len; ++gap) {
            for(left = 0, right = gap; right < len; ++left, ++right) {
                table[left][right] = (str[left] == str[right]) ? table[left+1][right-1] :
                        (Integer.min(table[left][right-1], table[left+1][right])+1);
            }
        }
        return table[0][right - 1];
    }

}
//Given a string,
//find the minimum number of characters to be inserted to convert it to palindrome.