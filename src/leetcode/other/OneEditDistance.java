package leetcode.other;

/**
 * Created by qifu on 17/2/7.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();

        if(len_s == len_t) return isOneModified(s,t);

        if(len_s - len_t == 1) return isOneDelete(s, t);
        if(len_t - len_s == 1) return isOneDelete(t, s);



        return false;
    }

    private boolean isOneModified(String s, String t){
        boolean modified = false;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(modified == true) return false;
                modified = true;
            }
        }
        return modified;
    }

    private boolean isOneDelete(String longer, String shorter){
        for(int i = 0; i < shorter.length(); i++){
            if(longer.charAt(i) != shorter.charAt(i)){
                return longer.substring(i + 1).equals(shorter.substring(i));
            }
        }
        return true;
    }


    /// clear shorter version
    public boolean isOneEditDistance(String s, String t) {

        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if(s.length() < t.length()){
                    return t.substring(i+1).equals(s.substring(i));
                } else {
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
