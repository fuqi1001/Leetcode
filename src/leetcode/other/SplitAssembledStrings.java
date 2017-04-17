package leetcode.other;

/**
 * Created by qifu on 17/4/15.
 */
public class SplitAssembledStrings {
    public String splitLoopedString(String[] strs) {
        char max = 'a';
        for(int i = 0; i < strs.length; i++) {
            for(char c: strs[i].toCharArray()) {
                if(c > max) { max = c;}
            }
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if(strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }

        String res = "";
        for(int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            for(String cur : new String[] {strs[i], rev} ) {
                for(int k = 0; k < cur.length(); k++) {
                    if(cur.charAt(k) != max) continue;
                    StringBuilder sb = new StringBuilder(cur.substring(k));

                    for(int j = i + 1; j < strs.length; j++) {
                        sb.append(strs[j]);
                    }
                    for(int j = 0; j < i; j++) {
                        sb.append(strs[j]);
                    }
                    sb.append(cur.substring(0,k));
                    if(sb.toString().compareTo(res) > 0) {
                        res = sb.toString();
                    }
                }
            }
        }
        return res;
    }
    /*
    先循环一遍整个String数组, 找到最大的字母max,肯定以此为开头 (优化部分)

    对每个循环到的String 做 reverse 来寻找是原始大 还是 reverse大, 若翻转后更大,则把翻转后的string替换原string

    再次循环整个数组, 取每个string 以及取反 来寻找以当前string或rev做头的序列是否为最大
    (优化)如果loop到的当前字符不为 最大字符max 则continue,

    以最大字符为开头,
    先把i 以后的字符串append到后面  然后把0-i 的字符串append到后面,再把 余下的substr append到后面
    最后在循环中比较每次得到的string是否为最大

     */
}
