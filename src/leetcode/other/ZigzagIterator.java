package leetcode.other;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 17/2/2.
 */
public class ZigzagIterator {
    private Iterator<Integer> i,j,temp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2){
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next(){
        if(j.hasNext()) {
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext(){
        return i.hasNext() || j.hasNext();
    }


    //---------------------

    LinkedList<Iterator> list;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2){
        list = new LinkedList<>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
