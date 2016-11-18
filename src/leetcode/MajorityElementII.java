package leetcode;

import java.util.ArrayList;
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
}
