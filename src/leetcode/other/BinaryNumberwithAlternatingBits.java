package leetcode.other;

public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        if(n == 1 || n == 0) return true;
        Integer num = new Integer(n);
        char[] str = num.toBinaryString(num).toCharArray();
        //System.out.println(str);
        char prev = str[0];
        for(int i = 1; i < str.length; i++) {
            char cur = str[i];
            if(prev == cur) return false;
            else {
                prev = cur;
            }
        }
        return true;
    }
}
