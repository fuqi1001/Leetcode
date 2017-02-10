package leetcode.other;

/**
 * Created by qifu on 17/2/10.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] nums = new int[m + n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = nums[pos2] + mult;

                nums[pos1] += sum / 10;
                nums[pos2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int cur : nums){
            if(!(cur == 0 && sb.length() == 0)){
                sb.append(cur);
            }
        }
        return sb.length() == 0? "0" : sb.toString();
    }
}
