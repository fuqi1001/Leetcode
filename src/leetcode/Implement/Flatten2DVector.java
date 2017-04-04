package leetcode.Implement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by qifu on 17/2/2.
 */
public class Flatten2DVector {

    Iterator<List<Integer>> list_it;
    Iterator<Integer> number_it;
    public Vector2D(List<List<Integer>> vec2d) {
        list_it = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return number_it.next();
    }

    @Override
    public boolean hasNext() {
        while((number_it == null || !number_it.hasNext()) && list_it.hasNext()) {
            number_it = list_it.next().iterator();
        }
        return number_it.hasNext();
    }
}
