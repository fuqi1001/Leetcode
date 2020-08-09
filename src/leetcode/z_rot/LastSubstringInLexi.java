package leetcode.z_rot;

public class LastSubstringInLexi {
    public String lastSubstring(String s) {
        int left = 0, right = 1;
        int offset = 0;
        int len = s.length();

        while(left + offset < len && right + offset < len) {
            char start = s.charAt(left + offset);
            char end = s.charAt(right + offset);

            if (start == end) offset++;
            else {
                if (start < end) {
                    left += offset + 1;
                } else {
                    right += offset + 1;
                }
                if (left == right) left++;
                offset = 0;
            }
        }
        return s.substring(Math.min(left, right));
    }
}
