package leetcode.other;

/**
 * Created by qifu on 16/12/3.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for(int i = len / 2; i >= 1; i--){
            if(len % i == 0){
                int substrLen = len / i;
                String cur = str.substring(0,i);
                int j = 0;
                for(j = 1; j < substrLen ; j++){
                    if(!cur.equals(str.substring(j * i, i + j * i))) break;
                }
                if(substrLen == j) return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern(String str) {
        for(int i = str.length() / 2; i >= 1; i++){
            if(str.length() % i == 0){
                int j = i;
                String cur = str.substring(0,j);
                while(str.indexOf(cur,j) == j) j += i;
                if( j == str.length()) return true;
            }
        }
        return false;
    }
}
