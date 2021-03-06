package leetcode.z_IXL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 17/4/21.
 */
public class threeSum {

    //O(N^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int sum = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while(left < right){
                    if(nums[i] + nums[left] + nums[right] == 0){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    /*
    First we sort the input array and run through all indices of a possible first element of the triplet
    for the rest of two elements of the triplet,
    all we need to is find a pair make it be -1 multi the first element.
    Other word, make the triplet sum be zero.
    Also we need to skip the equal elements to avoid duplicates in the answer
    we use two while loop the avoid that
    then we can get the list
     */
}
