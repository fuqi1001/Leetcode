package leetcode.z_Bloomberg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByZero {
    static class Pair implements Comparable<Pair>{
        int key;
        int value;
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    public static int bitCount(int num) {
        int count = 0;
        for(count = 0; num != 0; ++count) {
            num &= (num - 1);
        }
        return count;
    }

    public static void sortNum(int[] nums) {
        List<Pair> list = new ArrayList<>();
        for(int num : nums) {
            list.add(new Pair(num, bitCount(num)));
        }
        Collections.sort(list);
        for(Pair cur : list){
            System.out.println(cur.key +" " + cur.value);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        sortNum(nums);
    }

}
