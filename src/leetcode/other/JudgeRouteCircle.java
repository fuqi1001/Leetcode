package leetcode.other;

/**
 * Created by qifu on 17/8/13.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] ctr = moves.toCharArray();
        for(char c : ctr) {
            x += (c=='R'?1:0) + (c=='L'?-1:0); y += (c=='U'?1:0) + (c=='D'?-1:0);
        }
        return (x == 0)&&(y == 0);
    }
}
