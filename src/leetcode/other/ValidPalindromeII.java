package leetcode.other;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int head = -1;
        int tail = s.length();
        while(++head < --tail) {
            if(s.charAt(head) != s.charAt(tail)) {
                return check(s, head, tail + 1) || check(s, head - 1, tail);
            }
        }

        return true;
    }

    public boolean check(String s, int head, int tail) {
        while(++head < --tail) {
            if(s.charAt(head) != s.charAt(tail)) return false;
        }
        return true;
    }
}
