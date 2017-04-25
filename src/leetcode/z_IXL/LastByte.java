package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/25.
 */
public class LastByte {
    public static int check(int[] nums) {
        int i = 0;
        int flag = 0;
        for(; i < nums.length; ) {
            if(nums[i] > 127){
                i+=2;
                flag = 2;
            }
            else {
                i++;
                flag = 1;
            }
        }
        if(flag ==2 ) return 2;
        else return 1;
    }

    /*
    [127,128,127] 表示 1byte+2byte
    [128,127,127] 表示 2byte+1byte

     */
}
