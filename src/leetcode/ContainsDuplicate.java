package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by qifu on 16/8/29.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> Set = new HashSet<>();
        for(int ele : nums){
            if(! Set.add(ele)) return true;
        }
        return false;
    } // TLE

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 1 ; i ++){
            if(nums[i] == nums[ i + 1 ]) return true;
        }
        return false;

    }

    public boolean containsDuplicate(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            if( num < min){
                min = num;
            }
            if( num > max){
                max = num;
            }
        }

        boolean a[] = new boolean[max- min +1];
        for(int num : nums){
            if(a[num - min]) return true;
            else{
                a[num - min] = true;

            }
        }
        return false;
    }
}
