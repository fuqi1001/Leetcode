package leetcode;

/**
 * Created by qifu on 16/8/30.
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int[] word = new int[400];
        word['I'] = 1;
        word['V'] = 5;
        word['X'] = 10;
        word['L'] = 50;
        word['C'] = 100;
        word['D'] = 500;
        word['M'] = 1000;

        int len = s.length();
        int result = 0;

        result += word[s.charAt(0)];

        for(int i = 1 ; i < len ; i++){
            char temp = s.charAt(i);
            //System.out.println("***:" + word[temp]);
            if(word[temp] <= word[s.charAt(i-1)]){
                result += word[temp];
            }
            else{
                result = result - 2 * word[s.charAt(i-1)] + word[temp];
            }
        }

        return result;
    }
}
