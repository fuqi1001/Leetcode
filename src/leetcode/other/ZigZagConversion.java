package leetcode.other;

/**
 * Created by qifu on 16/9/22.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        int index = 0;
        while(index < len) {
            for(int i = 0; i < numRows && index < len; i++) {
                sb[i].append(s.charAt(index++));
            }
            for(int i = numRows - 2; i >= 1 && index < len; i--) {
                sb[i].append(s.charAt(index++));
            }
        }
        for(int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
/*
创建numRows个StringBuilder
按zigzag顺序上下移动append字符到相应排
 */
