package leetcode.Implement;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by qifu on 17/2/7.
 */
public class DesignPhoneDirectory {

    int max = 0;
    Set<Integer> used = new HashSet<>();
    Queue<Integer> available = new LinkedList<>();

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        for(int i = 0 ; i < maxNumbers; i++){
            available.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer get_num = available.poll();
        if(get_num == null) return -1;
        used.add(get_num);
        return get_num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number >= max || number < 0) return false;
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(used.remove(number)){
            available.add(number);
        }
    }
}
