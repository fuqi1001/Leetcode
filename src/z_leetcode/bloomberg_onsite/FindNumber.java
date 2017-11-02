package z_leetcode.bloomberg_onsite;

public class FindNumber {
    public int findPeak(int[] nums, int left, int right) {
        if(nums.length <= 2){
             return -1;
        }

        int mid = left + (right - left) / 2;
        if(left == mid || mid + 1 == right) {
            return -1;
        }
        if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        int point1 = findPeak(nums, left, mid);
        int point2 = findPeak(nums, mid, right);

        if(point1 != -1) {
            return point1;
        }
        if(point2 != -1) {
            return point2;
        }

        return -1;
    }

    public int findElement(int[] nums, int target) {
        int peak = findPeak(nums, 0, nums.length);

        int res = binarySearch(nums, 0, peak, target, true);
        if(res != -1) {
            return res;
        } else {
            return binarySearch(nums, peak+1, nums.length, target, false);
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target, boolean up) {
        if(up) {
            if(left > right) return -1;
            if(target > nums[right]) return -1;
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                return binarySearch(nums, left, mid - 1, target, true);
            } else {
                return binarySearch(nums, mid + 1, right, target, true);
            }
        } else {
            if(left > right) return -1;
            if(target > nums[left]) return -1;
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                return binarySearch(nums, mid + 1, right, target, false);
            } else {
                return binarySearch(nums, left, mid - 1, target, false);
            }
        }
    }
}
