package leetcode;

/**
 * Created by qifu on 16/10/26.
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        boolean left = true;
        int step = 1;
        int head = 1;
        int remaining = n;
        while(remaining > 1){
            if(left || remaining % 2 == 1){
                head += step;
            }
            remaining /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
