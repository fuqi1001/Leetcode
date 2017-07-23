package leetcode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qifu on 17/7/23.
 */
public class MaximumLengthofPairChain {
    class Pair {
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    class Mycomp implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Pair one = (Pair)o1;
            Pair two = (Pair)o2;
            if(one.y == two.y) {
                return two.x - one.x;
            }
            return one.y - two.y;
        }
    }
    public int findLongestChain(int[][] pairs) {
        List<Pair> list = new ArrayList<>();
        for(int[] pair: pairs) {
            Pair cur = new Pair(pair[0], pair[1]);
            list.add(cur);
        }
        Collections.sort(list, new Mycomp());
        int count = 1;
        int index = 0;
        for(int i = 1; i < list.size(); i++) {
            //System.out.println(list.get(i).x +" " + list.get(index).y);
            if(list.get(i).x <= list.get(index).y) continue;
            else {
                //System.out.println(list.get(i).x +" " +list.get(i).y +" "+ list.get(index).x+" "+list.get(index).y );
                index = i;
                count++;
            }
        }
        return count;
    }
}
