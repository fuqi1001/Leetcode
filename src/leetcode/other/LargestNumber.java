package leetcode.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qifu on 17/6/12.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] _nums = new String[nums.length];
        int index = 0;
        for(int cur : nums) {
            _nums[index++] = String.valueOf(cur);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(_nums, comp);
        if(_nums[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String cur : _nums) {
            sb.append(cur);
        }
        return sb.toString();
    }

    /*
    使用Comparator来比较组成的字符串的大小
    例如 o1="1" o2="23"
    s1 = "123"
    s2 = "231"
    选择后者
    将Comparator使用到Arrays.sort()中,可将String数组排序

     */
}
