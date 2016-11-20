package leetcode.other;

/**
 * Created by qifu on 16/9/5.
 */
public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        char c = 0;
        for(int i = 0 ; i < str1.length ; i++){
            c ^= str1[i];

        }
        for(int i = 0 ; i < str2.length ; i++){
            c ^= str2[i];
        }

        return c;
    }
}
