package leetcode.Implement;

import java.util.Iterator;

/**
 * Created by qifu on 16/10/25.
 */
public class PeekingIterator {
    Iterator<Integer> iterator;
    Integer cur;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.cur = iterator.hasNext() ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = cur;
        this.cur = iterator.hasNext() ? iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }
}
