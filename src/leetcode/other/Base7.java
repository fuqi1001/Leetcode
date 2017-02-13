package leetcode.other;

/**
 * Created by qifu on 17/2/13.
 */
public class Base7 {
    public String convertTo7(int num) {
        StringBuilder sb = new StringBuilder();

        if(num > 0){
            while(num >= 7){
                sb.append((num % 7) + "");
                num /= 7;
            }
            sb.append(num +"");
            return sb.reverse().toString();
        } else if(num < 0){
            num *= -1;
            while(num >= 7) {
                sb.append((num % 7) + "");
                num /= 7;
            }
            sb.append(num +"-");
            return sb.reverse().toString();
        } else return "0";
    }
}
