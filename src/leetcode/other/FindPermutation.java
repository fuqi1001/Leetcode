package leetcode.other;

/**
 * Created by qifu on 17/3/16.
 */
public class FindPermutation {
    /*
        I I I I I
       1 2 3 4 5 6
       I D D I D D D I
      1 4 3 2 8 7 6 5 9

      If it's all just I, then the answer is the numbers in ascending order.
      And if there are streaks of D,
      then just reverse the number streak under each:
     */

    public int[] findPermutation(String s) {
        if(s == null || s.length() == 0) return new int[0];
        int len = s.length();
        int[] res = new int[len + 1];
        for(int i = 0; i <= len; i++) {
            res[i] = i + 1;
        }
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == 'D') {
                int start = i;
                int end = start + 1;
                while(i < len && s.charAt(i) == 'D') {
                    end++;
                    i++;
                }
                reverse(res, start, end - 1);
            }
        }
        return res;
    }
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
