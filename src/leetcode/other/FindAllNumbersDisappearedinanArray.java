package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/12/30.
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int[] count = new int[len + 1];
        for(int cur : nums){
            count[cur]++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 1 ; i < len + 1; i++){
            if(count[i] == 0){
                res.add(i);
            }
        }
        return res;
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++ ){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }
        }

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < nums.length; i++){
            nums[ (nums[i] - 1) % n ] += n;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] <= n ) res.add(i+1);
        }

        return res;
    }
}
