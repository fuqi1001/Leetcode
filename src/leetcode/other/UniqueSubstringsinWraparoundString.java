package leetcode.other;

/**
 * Created by qifu on 16/12/3.
 */
public class UniqueSubstringsinWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        int[] map = new int[len];
        int[] count = new int[26];
        char[] ctr = p.toCharArray();
        for(int i = 0; i < len; i++) {
            int curLen = 1;
            if(i > 0 &&(ctr[i-1] + 1 == ctr[i] || (ctr[i-1] =='z' && ctr[i] == 'a'))) {
                curLen = map[i - 1] + 1;
            }
            map[i] = curLen;
            int index = ctr[i] - 'a';
            count[index] = Math.max(count[index], curLen);
        }
        int result = 0;
        for(int num : count) {
            result += num;
        }
        return result;

        /*
        分别用两个数组来储存中间的计算结果
        map储存当前字符是否可以符合条件组成子串,并记录到目前为止的最长长度

        count用来记录 以当前字符 c[i]结尾的子串的长度,
        长度就是组合数,然后把长度求和
        就得到Output
         */
    }
}
