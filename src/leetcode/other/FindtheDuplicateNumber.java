package leetcode.other;

/**
 * Created by qifu on 17/2/20.
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int min = 0;
        int max = nums.length - 1;

        while(min <= max){
            int mid = min + (max - min) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            if(count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    //https://segmentfault.com/a/1190000003817671
    //floyd cycle detecion
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);

        int find = 0;
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return slow;
    }
}
