package leetcode.other;

/**
 * Created by qifu on 17/4/9.
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if(n < 10) return -1;
        String str = n+"";
        char[] digit = str.toCharArray();
        int i = digit.length - 2;
        while(i >= 0 && digit[i] >= digit[i+1]) {
            i--;
        }

        if(i < 0) return -1;
        int j = digit.length - 1;
        while(j >= 0 && digit[j] <= digit[i]) {
            j--;
        }
        char temp = digit[i];
        digit[i] = digit[j];
        digit[j] = temp;
        reverse(digit, i + 1);
        try{
            return Integer.parseInt(new String(digit));
        }catch(Exception e){
            return -1;
        }



    }
    private void reverse(char[] digit, int left) {
        int right = digit.length - 1;
        while(left < right) {
            char temp = digit[left];
            digit[left] = digit[right];
            digit[right] = temp;
            left++;
            right--;
        }
    }

}
