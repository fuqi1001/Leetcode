package leetcode.other;

public class _1bit2bitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while(i < n - 1) {
            if(bits[i] == 0) i++;
            else i += 2;
        }
        return i == n - 1 ? true : false;
    }
}
