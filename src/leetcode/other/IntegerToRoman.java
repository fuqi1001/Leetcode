package leetcode.other;

/**
 * Created by qifu on 16/10/10.
 */
public class IntegerToRoman {
    public String intToRoman(int num){
        if(num <= 0) return "";
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int digit = 0;
        while(num > 0){
            int times = num / nums[digit];
            num -= nums[digit] * times;
            for(;times > 0;times--){
                res.append(symbols[digit]);
            }
            digit++;
        }
        return res.toString();
    }

    //more directly
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
