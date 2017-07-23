package leetcode.other;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qifu on 17/7/23.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 1;
        int number = 0;
        boolean[] vis = new boolean[nums.length];
        for(int cur : nums) {
            vis[cur - 1] = true;
            if( !set.add(cur)) {
                number = cur;
                //break;
            } else {
                index++;
            }
        }
        int[] res = new int[2];
        res[0] = number;
        for(int i = 0; i < nums.length; i++) {
            if(vis[i] == false) {
                //System.out.println(i);
                res[1] = i+1;
                break;
            }
        }
        return res;
    }
}
