package z_leetcode.bloomberg_onsite;

import java.util.Random;

public class FisherYate {
    public static void shuffle(int[] nums) {
        int len = nums.length;
        for(int i = len - 1; i >= 0; i--) {
            int randomIndex = new Random().nextInt(i+1);
            int itemIndex = nums[randomIndex];

            nums[randomIndex] = nums[i];
            nums[i] = itemIndex;
        }

        for(int n : nums) {
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < 10; i++) {
            System.out.println();
            shuffle(nums);
        }
    }
}
