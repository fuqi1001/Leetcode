package leetcode.Tree;

/**
 * Created by qifu on 17/3/16.
 */
public class BeautifulArrangement {
    int count = 0;
    public int countArrangement(int N) {
        if(N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }
    private void helper(int N, int pos, int[] used) {
        if(pos > N) {
            count++;
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(used[i] == 0 && ( (pos % i == 0) || (i % pos == 0) )){
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }

        }
    }

    //
    int count = 0;
    public int countArrangement(int N) {
        if(N == 0) return 0;
        helper(N, N, new int[N + 1]);
        return count;
    }
    private void helper(int N, int pos, int[] used) {
        if(pos  < 2) {
            count++;
            return;
        }
        for(int i = 1; i <= N; i++) {
            /*if(used[i] == 0 && ( (pos % i == 0) || (i % pos == 0) )){
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }*/
            if(used[i] == 1 || pos % i != 0 && i%pos != 0) continue;
            used[i] = 1;
            helper(N, pos - 1, used);
            used[i] = 0;
        }
    }
}
