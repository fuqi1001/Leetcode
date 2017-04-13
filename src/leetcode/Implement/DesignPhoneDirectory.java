package leetcode.Implement;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by qifu on 17/2/7.
 */
public class DesignPhoneDirectory {

    Set<Integer> set;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        set =new HashSet<>();
        for(int i = 0; i < maxNumbers; i++) {
            set.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(set.size() <= 0) return -1;
        else {
            int temp = 0;
            for(int num : set) {
                temp = num;
                break;
            }
            set.remove(temp);
            return temp;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        set.add(number);
    }


    //
    int[] numbers;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        numbers = new int[maxNumbers];
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) {
                numbers[i] = 1;
                return i;
            }
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return numbers[number] == 0;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        numbers[number] = 0;
    }
}
