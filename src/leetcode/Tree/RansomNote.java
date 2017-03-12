package leetcode.Tree;

/**
 * Created by qifu on 17/3/12.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            char cur = magazine.charAt(i);

            count[cur - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            char cur = ransomNote.charAt(i);
            if(--count[cur - 'a'] < 0) return false;
        }
        return true;
    }
}
