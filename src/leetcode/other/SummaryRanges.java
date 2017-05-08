package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/11/18.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> res = new ArrayList<>();

        for(int i = 0 ; i < len ; i++){
            int first = i;

            while((i + 1 < len) && nums[i+1] == nums[i] + 1){
                i++;
            }
            if(first == i){
                res.add(nums[i] +"");
            }else{
                res.add(nums[first] + "->" +nums[i]);
            }
        }
        return res;
    }
    /*
    用while循环跳过中间连续的部分 保存头尾
     */
}
