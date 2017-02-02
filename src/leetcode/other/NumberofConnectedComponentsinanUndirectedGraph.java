package leetcode.other;

/**
 * Created by qifu on 17/2/2.
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges){
        int[] roots = new int[n];
        for(int i = 0 ; i < n; i++){
            roots[i] = i;
        }

        for(int[] cur : edges){
            int root1 = find(roots, cur[0]);
            int root2 = find(roots, cur[1]);

            if(root1 != root2){
                roots[root1] = root2;
                n--;
            }
        }
        return n--;
    }

    public int find(int[] roots, int id){
        while(roots[id] != id){
            roots[id] = roots[roots[id]];   //compression
            id = roots[id];
        }
        return id;
    }

}
