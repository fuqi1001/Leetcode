package leetcode.other;

/**
 * Created by qifu on 17/1/5.
 */
public class ThirdMaximumNumber {
    //4144
    public int thirdMax(int[] nums){
        int max, mid, small;

        int count = 0;
        max = mid = small = Integer.MIN_VALUE;

        for(int num : nums){
            if(count > 0 && max == num || count > 1 && mid == num) continue;

            count++;

            if(num > max){
                small = mid;
                mid = max;
                max = num;
            } else if( num > mid){
                small = mid;
                mid = num;
            } else if( num > small){
                small = num;
            }


        }
        if(count >= 3 ){
            return small;
        }else {
            return max;
        }
    }
}
