package leetcode.z_rot;

public class BeauifulSubarray {
    public int first(int[] nums, int n) {
//        O(n^2)
        int count = 0;
        for(int i = 0; i < n; i++) {
            int odd = 0;
            for(int j = i; j < n; j++) {
                if (nums[j] % 2 == 1) odd++;
                if (odd == n) {
                    count++;
                }
            }
        }
        return count;
    }
    public int countSubarrays(int[] nums, int n) {
        /*
        * An efficient approach is to while traversing, compute the prefix[] array.
        * Prefix[i] stores the number of prefixes which has ‘i’ odd numbers in it.
        * We increase the count of odd numbers if the array element is an odd one.
        * When the count of odd numbers exceeds or is equal to m, add the number of prefixes which has “(odd-m)” numbers to the answer.
        * At every step odd>=m, we calculate the number of subarrays formed till a particular index with the help of prefix array.
        * prefix[odd-m] provides us with the number of prefixes which has “odd-m” odd numbers, which is added to the count to get the number of subarrays till the index.
        * */
        int count = 0;
        int len = nums.length;
        int[] prefix = new int[len];
        int odd = 0;
        for(int i = 0; i < len; i++) {
            prefix[odd]++;

            if ((nums[i] & 1) == 1) odd++;

            if (odd >= n) {
                /**
                 * Once we count odd === n, we can prepend all prefix[(odd - n == 0)] subarray
                 * once we count odd > n (like odd = n + 1), we can prepend all prefix[(odd - n == 1)] subarray
                 */
                count += prefix[odd - n];
            }
        }
        return count;
    }
}
