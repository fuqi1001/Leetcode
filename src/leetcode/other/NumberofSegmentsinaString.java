package leetcode.other;

/**
 * Created by qifu on 16/12/3.
 */
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        int seg = 0;
        int chars = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(chars > 0){
                    seg++;

                }
                chars = 0;
            }
            else{
                chars++;
            }
        }
        if(chars > 0) seg++;
        return seg;
    }
}
