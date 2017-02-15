package leetcode.Tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qifu on 17/2/15.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        int len = nums.length;
        String[] str_num = new String[len];

        for(int i = 0; i < len; i++){
            str_num[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        };

        Arrays.sort(str_num, comp);

        if(str_num[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String cur : str_num){
            sb.append(cur);
        }
        return sb.toString();
    }
}
