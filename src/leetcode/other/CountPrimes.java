package leetcode.other;

/**
 * Created by qifu on 16/9/22.
 */
public class CountPrimes {
    public int countPrimes(int n){
        boolean[] notPrime = new boolean[n+2];
        notPrime[0] = notPrime[1] = true;
        for(int i = 2 ; i * i<n ;i++){
            if(!notPrime[i]){
                int c =i * i;
                while(c < n){
                    notPrime[c] = true;
                    c+=i;
                }
            }
        }
        int result=0;
        for(int i = 0 ; i < n ;i++){
            if(!notPrime[i]) result++;
        }
        return result;
    }

    //
    public int countPrimes(int n) {
        boolean[] not = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!not[i]) {
                count++;
                for(int j = 2 ; i * j < n; j++) {
                    not[i * j] = true;
                }
            }
        }
        return count;
    }
}
