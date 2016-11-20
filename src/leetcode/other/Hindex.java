package leetcode.other;

/**
 * Created by qifu on 16/10/26.
 */
public class Hindex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] map = new int[n+1];
        for(int i = 0 ; i < n ;i++){
            if(citations[i] > n) map[n]++;
            else {
                map[citations[i]]++;
            }
        }

        for(int i = n ; i > 0 ;i--){
            if(map[i] > i) return i;
            map[i - 1] += map[i];
        }
        return 0;

    }
}
