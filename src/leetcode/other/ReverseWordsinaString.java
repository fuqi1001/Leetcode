package leetcode.other;

/**
 * Created by qifu on 17/2/8.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if(s == null) return s;
        char[] words = s.toCharArray();
        reverse(words, 0, words.length - 1);
        reverseWord(words, words.length);
        return cleanSpcae(words, words.length);
    }

    private void reverse(char[] words, int start, int end){
        while(start < end){
            char temp = words[start];
            words[start++] = words[end];
            words[end--] = temp;
        }
    }

    private void reverseWord(char[] words, int len){
        int i = 0, j = 0;
        while(i < len){
            while( i < j || i < len && words[i] == ' ') i++;  //skip space
            while( j < i || j < len && words[j] != ' ') j++;  //get next full word  from i -> j;
            reverse(words, i, j - 1);
        }
    }

    private String cleanSpcae(char[] words, int len){
        int i = 0, j = 0;
        while(j < len){
            while(j < len && words[j] == ' ') j++;
            while(j < len && words[j] != ' ') words[i++] = words[j++];
            while(j < len && words[j] == ' ') j++;
            if(j < len) words[i++] = ' ';
        }
        return new String(words).substring(0, i);
    }

    ///string Builder way

    public String reverseWords(String s) {
        if(s == null) return s;
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = str.length - 1; i >=0 ; i--){
            if(!str[i].equals("")){
                sb.append(str[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }


    //
    public String reverseWords(String s) {
        if(s.length() < 1) return s;
        int startIndex = 0;
        char[] str = s.toCharArray();
        reverse(str, 0, str.length - 1);
        for(int i = 0; i < str.length; i++) {
            if(str[i] != ' '){
                if(startIndex != 0) str[startIndex++] = ' ';
                int j = i;
                while(j < str.length && str[j] != ' ') {
                    str[startIndex++] = str[j++];
                }
                reverse(str, startIndex - (j - i), startIndex - 1);
                i = j;
            }
        }
        return new String(str, 0, startIndex);
    }

    private void reverse(char[] ctr, int start, int end) {
        for(; start < end; start++, end--) {
            char temp = ctr[start];
            ctr[start] = ctr[end];
            ctr[end] = temp;
        }
    }
}
