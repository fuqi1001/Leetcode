package leetcode.other;

/**
 * Created by qifu on 16/12/1.
 */
public class Flipgame2 {
    public boolean canWin(String s) {
        boolean[] check = new boolean[s.length()];
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '+') check[i] = true;
            else check[i] = false;
        }
        return search(check);
    }
    public boolean search(boolean[] check){
        for(int i = 0 ; i < check.length - 1; i++){
            if(check[i] && check[i+1]){
                check[i] = false;
                check[i+1] = false;
                if(!search(check)){
                    check[i] = true;
                    check[i+1] = true;
                    return true;
                } else{
                    check[i] = true;
                    check[i+1] = true;
                }
            }
        }
        return false;
    }
}
