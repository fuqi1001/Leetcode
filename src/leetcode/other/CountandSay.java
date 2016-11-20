package leetcode.other;

/**
 * Created by qifu on 16/9/16.
 */
public class CountandSay {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String str = countAndSay(n - 1);

        int len = str.length();
        StringBuilder result = new StringBuilder();
        int num = 1;
        char temp;
        for(int i = 0 ; i < len ; i++){

            temp = str.charAt(i);

            while(i + 1< len && str.charAt(i) == str.charAt(i+1)){
                num++;
                i++;

            }
            result.append(num).append(temp);
            //System.out.println("num: "+num);
            num = 1;
        }

        return result.toString();
    }
}
