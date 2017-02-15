package leetcode.twoSigma;

/**
 * Created by qifu on 17/2/15.
 */
public class friendsCircle {
    int[] map;
    int count;

    public int friendCircles(String[] friends){
        if(friends == null || friends.length == 0) return 0;
        int len = friends.length;
        map = new int[len];
        for(int i = 0; i < len; i++){
            map[i] = i;
        }
        count = len;

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(friends[i].charAt(j) == 'Y' && !isConnected(i,j)){
                    union(i,j);
                }
            }
        }
        return count;
    }

    private int find(int i ){
        return map[i];
    }
    private void union(int point1, int point2){
        int root1 = map[point1];
        int root2 = map[point2];
        if(root1 != root2){
            for(int i = 0; i < map.length; i++){
                if(map[i] == root2) {
                    map[i] = root1;
                }
            }
            count--;
        }
    }
    private boolean isConnected(int point1, int point2) {
        return find(point1) == find(point2);
    }
}
