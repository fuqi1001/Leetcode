package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 16/11/18.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Integer num_one = null , num_two = null;
        int count_one = 0, count_two = 0;
        for(int curNum : nums){
            if(num_one != null && curNum == num_one.intValue()){
                count_one++;
            }
            else if(num_two != null && curNum == num_two.intValue()){
                count_two++;
            }
            else if(count_one == 0){
                count_one = 1;
                num_one = curNum;
            }
            else if(count_two == 0){
                count_two = 1;
                num_two = curNum;
            }
            else{
                count_one--;
                count_two--;
            }
        }

        count_one = count_two = 0;

        for(int curNum : nums){
            if(curNum == num_one.intValue()){
                count_one++;
            }
            else if(curNum == num_two.intValue()){
                count_two++;
            }
        }
        if(count_one > nums.length / 3){
            result.add(num_one);
        }
        if(count_two > nums.length / 3){
            result.add(num_two);
        }

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
