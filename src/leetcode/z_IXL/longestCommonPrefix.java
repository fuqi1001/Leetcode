package leetcode.z_IXL;

import java.util.Arrays;

/**
 * Created by qifu on 17/4/22.
 */
public class longestCommonPrefix {
    //O(k nlogn)  n is the number of the strings, k is the average length

    /*
    sort the array first,
    then what we need to do is just compare the first and the last element in the sorted array
    character by character, until get the different element
    break the loop, return result;

     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if(strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for(int i = 0; i < a.length; i++) {
                if(b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }

    //O(n*l)  n是字符串个数, l是prefix长度
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int n = strs.length;
        if(n == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < n; j++) {
                if(strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    /*
    use a stringbuilder element keep the result prefix
    we use the first element in the string array as the reference
    then go through the rest of the array
    character by character,
    once we get a character doesnt match with the first elements
    we break the loop and then cover the stringBuilder to string and return the string
     */
}
