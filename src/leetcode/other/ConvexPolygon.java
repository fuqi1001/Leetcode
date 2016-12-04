package leetcode.other;

import java.util.List;

/**
 * Created by qifu on 16/12/3.
 */
public class ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points){
        if(points.size() == 3) return true;

        points.add(points.get(0));
        points.add(points.get(1));

        int i = 0, sign = 0;
        List<Integer> p1 = null, p2 = null;
        for(List<Integer> p : points) {
            if(i == 0) p2 = p;
            else if( i == 1) p1 = p;
            else{
                int curr = getArea(p2,p1,p);
                if(sign == 0 || sign == curr){
                    sign = curr;
                }
                else if(curr != 0){
                    return false;
                }
                p2 = p1;
                p1 = p;
            }
            i++;
        }
        return true;
    }

    private int getArea(List<Integer> a, List<Integer> b, List<Integer> c) {
        int area = ( a.get(0) * b.get(1) + a.get(1) * c.get(0) + b.get(0) * c.get(1)
                - a.get(0) * c.get(1) - a.get(1) * b.get(0) - b.get(1) * c.get(0));

        if (area != 0) return area / Math.abs(area);
        return 0;
    }
}
