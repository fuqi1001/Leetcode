package leetcode.z_IXL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * Created by qifu on 17/4/21.
 */
public class duplicateNumber {
    //直接HashSet
    public List duplicate(int[] number) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int num : number) {
            if(!set.add(num)) {
                res.add(num);
            }
        }
        return res;
    }

    //数组保存
    public List duplic_array(int[] number) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> res = new ArrayList<>();

        for(int num : number) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        boolean[] count = new boolean[max - min];
        for(int num : number) {
            if(count[num - min]) res.add(num);
            else count[num - min] = true;
        }
        return res;
    }

    //如果是给定0~n-1  O(n) time, O(1) space
    /*
    Basically we can directly use hashSet deal with this problem, but that need extra space
    So i willing to do this in place with the origin array
    because the range is 0~n-1, so the value of the array can also be use as the index
    we just need to go through one time of the array
    use the value of each element as index, to set the value sign be minus
    once we get a minus value, we know that this index be use more than once,
    mean the element is duplicate.

     */
    public List duplicate(int[] number) {
        int len = number.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            if(number[Math.abs(number[i])] >= 0) {
                number[Math.abs(number[i])] = -1 * number[Math.abs(number[i])];
            } else {
                res.add(Math.abs(number[i]));
            }
        }
        return res;
    }

}
