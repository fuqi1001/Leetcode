package leetcode.other;

/**
 * Created by qifu on 16/9/16.
 */
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int len = secret.length();
        int a = 0, b = 0;
        for(int i = 0 ; i < len ; i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if(s == g) a++;
            else{
                if(map[s] < 0) b++; //当测secret的字母的时候,map[s]<0,说明有guess先操作过,说明有相同值在guess中
                if(map[g] > 0) b++;//当测secret的字母的时候,map[g]>0,说明有secret先操作过,说明有相同值在secret中
                map[s]++;
                map[g]--;
            }
        }
        return a+"A"+b+"B";
    }
}
