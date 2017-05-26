package leetcode.other;

/**
 * Created by qifu on 17/2/8.
 */
public class ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        int len = s.length - 1;
        reverse(s, 0, len);
        int start = 0;
        for(int i = 0; i <= len; i++) {
            if(s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, len);
    }
    public void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end] ;
            s[end] =  temp;
            start++;
            end--;
        }
    }
    /*
    先整个翻转,再对每个词进行翻转
     */
}
