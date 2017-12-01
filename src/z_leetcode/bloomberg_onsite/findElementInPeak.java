package z_leetcode.bloomberg_onsite;

public class findElementInPeak {
    public int findPeak(int[] nums, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if(nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else if(nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findUp(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findDown(int[] nums, int left, int right, int target) {

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findElementInPeak t = new findElementInPeak();
        int[] nums = {5,6,7,8,9,10,4,3,2,1};
        int peak = t.findPeak(nums, 0, nums.length);
        if(t.findUp(nums, 0, peak, 10) != -1) System.out.println(t.findUp(nums, 0, peak, 10));
        else if(t.findDown(nums, peak+1, nums.length - 1, 10) != -1) System.out.println(t.findDown(nums, peak+1, nums.length - 1, 10));
        else System.out.println(-1);
    }
}
