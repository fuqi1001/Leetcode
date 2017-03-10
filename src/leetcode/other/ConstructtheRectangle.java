package leetcode.other;

/**
 * Created by qifu on 17/3/10.
 */
public class ConstructtheRectangle {
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while(area % width != 0) width--;
        return new int[] {area/width, width};
    }
}
