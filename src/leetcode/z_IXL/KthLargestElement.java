package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/21.
 */
public class KthLargestElement {
    public int findKth(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];

        for(int cur: nums) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }

        int[] count = new int[max - min + 1];

        for(int cur : nums) {
            count[cur - min]++;
        }

        int res = 0;

        for(int i = count.length - 1; i >= 0; i--) {
            k -= count[i];
            if(k <= 0) {
                res = i + min;
                break;
            }
        }
        return res;
    }
    /*
    找这个数组的范围
    以每个数字与最小值的差为index 保存每个number出现的次数
    然后倒序找
    first, we go through the array to find the range of this array
    then go through again the array, count the element minus minimal element in the array
    use the different as the index, keep the frequency of a element show up in an array name count
    At the end, we go through the count array from the end.
    Because the end of the count always the larges element in the origin array
    keep k - frequencey of current element , until k less or equal 0
    the use the index + minimal we can get the original element
    which is the kth largest element

     */
}
