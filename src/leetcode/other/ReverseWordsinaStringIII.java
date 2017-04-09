package leetcode.other;

/**
 * Created by qifu on 17/4/9.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length - 1 ; i++){
            sb.append(reverse(words[i])).append(" ");
        }
        sb.append(reverse(words[words.length - 1]));
        return sb.toString();
    }
    private String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
