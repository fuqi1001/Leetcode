package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 16/12/1.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s){
        int gLen = g.length;
        int sLen = s.length;

        int ans = 0;
        int i, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for(int i = 0 ;i < gLen; i++){
            while(j < sLen && s[j] < g[i]){
                j++;
            }
            if(j < sLen){
                ans++;
                j++
            }else{
                break;
            }
        }
        return ans;
    }

}
