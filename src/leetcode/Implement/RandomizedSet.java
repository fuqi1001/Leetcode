package leetcode.Implement;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by qifu on 17/2/3.
 */
public class RandomizedSet {

    HashMap<Integer, Integer> locs;
    ArrayList<Integer> nums;
    java.util.Random rand = new java.util.Random();


    /** Initialize your data structure here. */
    public RandomizedSet() {
        locs = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = locs.containsKey(val);
        if(contains) return false;

        int index = nums.size();
        locs.put(val, index);
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contains = locs.containsKey(val);
        if(!contains) return false;

        int index = locs.get(val);
        if(index != nums.size() - 1){
            int lastNum = nums.get(nums.size() - 1);
            locs.put(lastNum, index);
            nums.set(index, lastNum);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size() - 1));
    }
}
