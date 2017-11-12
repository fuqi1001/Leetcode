package leetcode.other;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for(int i = 1 ; i < len ;i++) {
            sum[i] += sum[i-1] + nums[i];
        }
        int index = -1;
        if(sum[len - 1] - sum[0] == 0) return 0;
        for(int i = 1; i < len; i++) {
            //System.out.println(sum[i - 1] +" " + sum[len - 1]);
            if(sum[i - 1] == sum[len - 1] - sum[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
