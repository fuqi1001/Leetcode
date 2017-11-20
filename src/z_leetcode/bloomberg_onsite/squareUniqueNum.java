package z_leetcode.bloomberg_onsite;

public class squareUniqueNum {public int squareUniqueNum(int[] nums) {
    int len = nums.length;
    if(len < 2) return len;

    int left = 0, right = len - 1;
    int pre = Math.abs(nums[0]);
    int count = 1;
    while(left <= right) {
        if(Math.abs(nums[left]) > Math.abs(nums[right])) {
            if(pre != Math.abs(nums[left])) {
                count++;
                pre = Math.abs(nums[left]);
            }
            left++;
        } else {
            if(pre != Math.abs(nums[right])) {
                count++;
                pre = Math.abs(nums[right]);
            }
            right--;
        }
    }
    return count;
}
}
