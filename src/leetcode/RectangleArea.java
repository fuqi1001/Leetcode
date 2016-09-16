package leetcode;

/**
 * Created by qifu on 16/9/16.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areA = (C-A) * (D-B);
        int areB = (G-E) * (H-F);

        int lowerUp = Math.min(D,H);
        int HigherDown = Math.max(B,F);
        int lefterRight = Math.min(C,G);
        int RighterLeft = Math.max(A,E);
        int over = 0;
        if(lowerUp > HigherDown && lefterRight > RighterLeft) {
            over = (lowerUp - HigherDown) * (lefterRight - RighterLeft);
        }
        return areA+areB-over;

    }
}
