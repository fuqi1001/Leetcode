package leetcode.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qifu on 16/8/18.
 */
public class IntersectionofTwoArrays {
    // version 1: sort & merge
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] temp = new int[nums1.length];
        int i = 0 ;
        int j = 0 ;
        int index = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                if(index == 0 || temp[index - 1] != nums1[i] ){
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }

        int[] result = new int[index];
        for(int k = 0 ; k < index; k++){
            result[k] = temp[k];
        }
        return result;
    }

    // version 2: hash map
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return null;
        }

        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0 ; i < nums1.length ; i++){
            hash.add(nums1[i]);
        }

        HashSet<Integer> resultHash = new HashSet<>();
        for(int i = 0 ; i < nums2.length ; i++){
            if(hash.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }
        int index = 0;
        int[] result = new int[resultHash.size()];
        for(Integer num : resultHash){
            result[index++] = num;
        }

        return result;

    }

    //binary search

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            /*if (binarySearch(nums2, num)) {
                set.add(num);
            }*/
            if(Arrays.binarySearch(nums2, num) >= 0) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    /*public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }*/
}
