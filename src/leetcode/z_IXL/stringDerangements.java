package leetcode.z_IXL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/4/24.
 */
public class stringDerangements {
    public static void main(String[] args) {
        derangement("abc");
        System.out.println("===========");
    }

    public static void derangement(String strs) {
        char[] ctr = strs.toCharArray();
        int len = strs.length();
        char[] origin = ctr;
        derangement( origin, new boolean[len], new StringBuilder(), new ArrayList<>());
    }

    public static void derangement( char[] origin, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == origin.length ) {
            result.add(sb.toString());
        }
        for (int i = 0; i < origin.length; i++) {
            if(used[i] == true || (i != 0 && origin[i] == origin[i-1] && used[i-1] == true) || sb.length() == i) continue;
            used[i] = true;
            sb.append(origin[i]);
            derangement( origin, used, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    /*
    use a backtrack or dfs way to recursive solve this problem,
    what we need to do is generate all the permutation of the string
    but omit the string which has the character in origin place
    First, we cover the string to a char array,
    and create a boolean array to check the character be visited or not,
    create a StringBuilder object to keep the current string we get in each recursive
    and a result list to keep the result.

    first, we check the StringBuilder object's length, if the length equal the char array size,
    we cover the StringBuilder object to string and add it to the result list.

    use a for loop to go through all character in the char array
    there are 3 point we should check first,
    first, current character be use or not if true we need directly to go next character
    then check prev character equal current character and prev character be visited already,
    if true we need directly to go next character
    then check the stringBuilder length, if length equal to the index of the character we need to go to next character
    because we dont want the character be in the origin place

    after check this, we set the current character be used, and append to the StringBuild object,
    recursive use the function
    then delete the last character from the stringBuilder object
    set current character not be used.

     */
}
