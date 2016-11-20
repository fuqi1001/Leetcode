package leetcode.other;

/**
 * Created by qifu on 16/10/10.
 */
public class MaximumProductofWordLengths {
    public static int maxProduct(String[] words){
        if(words == null || words.length == 0) return 0;
        int len = words.length;

        int[] value = new int[words.length];

        for(int i = 0 ; i < len ;i++){
            value[i] = 0;
            String temp = words[i];

            for(int j = 0 ; j < temp.length(); j++){
                value[i] |= 1<< (temp.charAt(j)-'a');
            }
        }

        int result = 0;
        for(int i = 0 ; i < len ;i++){
            for(int j = i ; j < len ;j++){
                if((value[i] & value[j]) == 0 && words[i].length() * words[j].length() > result){
                    result = words[i].length() * words[j].length();
                }
            }
        }
        return result;
    }
}
