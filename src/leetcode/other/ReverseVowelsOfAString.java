package leetcode.other;

/**
 * Created by qifu on 16/9/7.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();
        while(left < right){
            if(isVowel(str[left]) && isVowel(str[right])){
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
            if(!isVowel(str[left])) left++;
            if(!isVowel(str[right])) right--;
        }
        return new String(str);
    }

    public boolean isVowel(char c){
        c = Character.toLowerCase(c);
        if(c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
    //
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1) return s;
        int start = 0;
        int end = s.length() - 1;
        char[] str = s.toCharArray();
        String vowels = "aeiouAEIOU";
        while(start < end) {


            if(vowels.contains(str[start]+"") && vowels.contains(str[end]+"")){
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;
                start++;
                end--;
            }
            if(!vowels.contains(str[start]+"")) start++;
            if(!vowels.contains(str[end]+"")) end--;
        }
        return new String(str);
    }
}
