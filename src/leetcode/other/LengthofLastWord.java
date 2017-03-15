package leetcode.other;

/**
 * Created by qifu on 16/9/20.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int count = 0;
        for(int i = str.length()-1;i>=0;i--){
            if(str.charAt(i) != ' ') count++;
            else break;
        }
        return count;
    }


    public int lengthOfLastWord(String s) {
        int count  = 0;
        int index = 0;
        if(s == null || s.length() == 0) return 0;

        for(int i = s.length()-1;i>=0 ;i--){
            if(s.charAt(i) != ' '){
                index = i;
                break;
            }
        }

        for(int i = index ; i >=0 ;i--){
            if(s.charAt(i) != ' '){
                count++;
            }
            else break;
        }

        return count;
    }

    //
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        s = "x " + s;
        String[] str = s.split(" +");
        if(str.length == 1) return 0;
        return str[str.length - 1].length();
    }
}
