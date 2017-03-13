package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 16/12/2.
 */
public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        int num = points.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < num ; i++){
            for(int j = 0 ; j < num ; j++){
                if(i == j) continue;

                int dis = getDistance(points[i],points[j]);

                map.put(dis, map.getOrDefault(dis,0)+1);
            }

            for(int val : map.values()){
                res += val * (val - 1);
            }
            map.clear();

        }
        return res;
    }
    private int getDistance(int[] a, int[] b){
        return (a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    //
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int[] point1 : points) {
            for(int[] point2 : points) {
                if(point1 == point2) continue;
                int dist = (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) *(point1[1] - point2[1]);
                int prev = map.containsKey(dist) ? map.get(dist) : 0;
                res += 2 * prev;
                map.put(dist, prev + 1);
            }
            map.clear():
        }
        return res;
    }
    /*
    * 2 * prev
    *
    * */
}
