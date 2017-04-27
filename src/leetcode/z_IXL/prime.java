package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/27.
 */
public class prime {
    //O(n * sqrt(n))
    public int[] getPrime(int n) {
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i < Math.sqrt(n); i++) {
            if(res[i] == 0) {
                for(int j = i * i ; j < n; j+= i) {
                    res[i] = 1;
                }
            }
        }
        return res;
    }
    public void output_p(int[] res) {
        for(int i = 0; i < res.length; i++) {
            if(res[i] == 0) {
                System.out.println(i);
            }
        }

    }
}
