package leetcode.other;

/**
 * Created by qifu on 17/3/9.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
    //
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||
                word.equals(word.toLowerCase()) ||
                Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
    }
    //
    public boolean detectCapitalUse(String word) {
        int countUp = 0;
        for(int i = 0; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))) countUp++;
        }
        if(countUp == 1) return Character.isUpperCase(word.charAt(0));
        else {
            return countUp == 0 || countUp == word.length();
        }
    }
}
