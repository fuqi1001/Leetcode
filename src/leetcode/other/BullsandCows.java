package leetcode.other;

import java.util.HashMap;
import java.util.Map;

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

    //hashmap way
    
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int len = secret.length();
        Map<Character, Integer> mapa = new HashMap<>();
        Map<Character, Integer> mapb = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char ca = secret.charAt(i);
            char cb = guess.charAt(i);
            mapa.put(ca, mapa.getOrDefault(ca, 0) + 1);
            mapb.put(cb, mapb.getOrDefault(cb, 0) + 1);
            if(ca == cb) a++;
        }
        for(char key : mapa.keySet()) {
            if(mapb.containsKey(key)) {
                b += Math.min(mapa.get(key), mapb.get(key));
            }
        }
        b -= a;
        String res = a+"A"+b+"B";
        return res;
    }
}
