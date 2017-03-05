package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/3/5.
 */
public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int N) {
        if(picture == null) return 0;
        int m = picture.length;
        int n = picture[0].length;

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            String key = scanRow(picture, i, N);

            if(key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int res = 0;
        for(String key : map.keySet()) {
            if(map.get(key) == N) {
                for(int i = 0; i < n; i++) {
                    if(key.charAt(i) == 'B' && scanCol(picture, i) == N) {
                        res += N;
                    }
                }
            }
        }
        return res;
    }
    public String scanRow(char[][] picture, int row, int N) {
        int n = picture[row].length;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(picture[row][i] == 'B') {
                count++;
            }
            sb.append(picture[row][i]);
        }
        return count == N ? sb.toString() : "";
    }
    public int scanCol(char[][] picture, int col) {
        int n = picture.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(picture[i][col] == 'B') {
                count++;
            }
        }
        return count;
    }


    /*
    * 先扫行, 把有N个B的全部都扫出来存进map
    * 在keySet 取出来, 已每一行为基础,扫为B元素那一列, 如果那一列为N, 则res += N*/
}
