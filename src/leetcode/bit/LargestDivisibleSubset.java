package leetcode.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 17/4/11.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int len = nums.length;
        int[] count = new int[len];
        int[] pre = new int[len];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for(int i = 0; i < len; i++) {
            count[i] = 1;
            pre[i] = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0){
                    if(count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if(count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        while(index != -1){
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
    /*
    开两个数组,一个存count表示这一串符合条件的子串长度是多少
    一个Pre 存前一个点的index,
    扫下来pre里面就存了整个子串的index

    对原串排序
    从小往大扫,内部从cur index 往回扫求余,

    整个扫下来就可以得到最长的子串
    然后通过pre把子串存入List
     */
}
