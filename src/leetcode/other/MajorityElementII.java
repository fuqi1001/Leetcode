package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 16/11/18.
 */
public class MajorityElementII {
    /*
    思路是,一个数组中出现次数大于n/3的数字最多只有两个,
    所以只需要两个mark来统计就好
    在循环完成一次后,就会选出两个重复次数最多的数
    然后再循环一次判断是否大于n/3

     */
    public List<Integer> majorityElement(int[] nums) {
        int mark_a = 0;
        int mark_b = 0;
        int count_a = 0;
        int count_b = 0;
        for(int num : nums) {
            if(num == mark_a) count_a++;
            else if(num == mark_b) count_b++;
            else if(count_a == 0) {
                mark_a = num;
                count_a = 1;
            }
            else if(count_b == 0)  {
                mark_b = num;
                count_b = 1;
            } else {
                count_a--;
                count_b--;
            }
        }
        count_a = 0;
        count_b = 0;
        for(int num : nums) {
            if(num == mark_a) count_a++;
            else if(num == mark_b) count_b++;
        }
        List<Integer> result = new ArrayList<>();
        if(count_a > nums.length / 3) result.add(mark_a);
        if(count_b > nums.length / 3) result.add(mark_b);
        return result;
    }

    //////================   n / k

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length , k = 3;
        List<Integer> result = new ArrayList<>();
        if(n == 0 || k < 2) return result;

        int[] candidates = new int[k - 1];
        int[] count = new int[k - 1];

        for(int num: nums){
            boolean settled = false;
            for(int i = 0 ; i < k - 1; i++){
                if(candidates[i] == num){
                    count[i]++;
                    settled = true;
                    break;
                }
            }
            if(settled) continue;
            for(int i = 0 ;  i < k - 1; i++){
                if(count[i] == 0){
                    count[i] = 1;
                    candidates[i] = num;
                    settled = true;
                    break;
                }
            }
            if(settled) continue;
            for(int i = 0 ; i < k - 1; i++){
                count[i] = (count[i] > 0) ? (count[i] - 1) : 0;
            }
        }

        Arrays.fill(count,0);
        for(int num : nums){
            for(int i = 0 ; i < k - 1; i++){
                if(candidates[i] == num){
                    count[i]++;
                    break;
                }
            }
        }
        for(int i = 0 ; i < k - 1; i++){
            if(count[i] > n / k) result.add(candidates[i]);
        }
        return result;
    }

}
