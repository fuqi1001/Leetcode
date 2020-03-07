package leetcode.z_amazon;

import java.util.Arrays;
import java.util.Comparator;

public class reOrderLog {
    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        boolean[] isLetterArr = new boolean[len];
        int lenLetter = 0;
        for(int i= 0; i < len; i++) {
            String curStr = logs[i];
            boolean isLetter = Character.isLetter(curStr.charAt(curStr.length() - 1));
            if (isLetter) lenLetter++;
            isLetterArr[i] = isLetter;
        }

        String[] ans = new String[logs.length];
        for(int i = 0, j = 0, k = lenLetter; i < logs.length; i++) {
            if (isLetterArr[i]) {
                ans[j] = logs[i];
                j++;
            } else {
                ans[k] = logs[i];
                k++;
            }
        }
        Arrays.sort(ans, 0, lenLetter, new Comparator<String>() {
            public int compare(String o1, String o2) {
                int idx1 = o1.indexOf(' ');
                int idx2 = o2.indexOf(' ');
                String str1 = o1.substring(0, idx1);
                String str2 = o2.substring(0, idx2);
                String tailWord1 = o1.substring(idx1);
                String tailWord2 = o2.substring(idx2);
                if (!tailWord1.equals(tailWord2)) return tailWord1.compareTo(tailWord2);
                else return str1.compareTo(str2);
            }
        });
        return ans;
    }
}
