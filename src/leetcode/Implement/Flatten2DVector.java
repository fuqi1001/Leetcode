package leetcode.Implement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by qifu on 17/2/2.
 */
public class Flatten2DVector {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return j.next();
    }

    @Override
    public boolean hasNext() {
        while( (j == null || !j.hasNext()) && i.hasNext() ){
            j = i.next().iterator();
        }
        return j!=null && j.hasNext();
    }
}
