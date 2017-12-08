package z_leetcode.bloomberg_onsite;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU {
    HashMap<Integer, Integer> vals;             //<key, value>
    HashMap<Integer, Integer> countFreq;        //<key, frequence>
    HashMap<Integer, LinkedHashSet<Integer>> lists;  //<frequence, listOfThisFrequence<index>>
    int cap;
    int min = -1;

    public LFU(int capacity) {
        vals = new HashMap<>();
        countFreq = new HashMap<>();
        lists = new HashMap<>();
        this.cap = capacity;
        lists.put(1, new LinkedHashSet());
    }

    public int get(int key) {
        if(!vals.containsKey(key)) return -1;
        int count = countFreq.get(key);
        countFreq.put(key, count + 1);
        lists.get(count).remove(key);
        if(count == min && lists.get(count).size() == 0) {
            min++;
        }
        if(!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet());
        }
        lists.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if(cap <= 0) return;
        if(vals.containsKey(key)) {
            vals.put(key,value);
            get(key);
            return;
        }
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        countFreq.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }

}
