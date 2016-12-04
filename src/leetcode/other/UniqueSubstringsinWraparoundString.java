package leetcode.other;

/**
 * Created by qifu on 16/12/3.
 */
public class UniqueSubstringsinWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] maxLen = new int[26];
        char[] c = p.toCharArray();
        int len = p.length();

        int[] letterLen = new int[len];

        for(int i = 0 ; i < len; i++){
            int curLen = 1;
            if(0 < i && (c[i] == c[i-1] + 1 || (c[i-1] =='z' && c[i] == 'a'))){
                curLen = letterLen[i - 1] + 1;
            }
            letterLen[i] = curLen;
            int id = c[i] - 'a';
            maxLen[id] = Math.max(maxLen[id], curLen);

        }
        int result = 0;
        //子串长度就是 子串能出现的排列数
        for(int i =0 ; i < 26 ; i++){
            result += maxLen[i];
        }
        return result;
    }
}
