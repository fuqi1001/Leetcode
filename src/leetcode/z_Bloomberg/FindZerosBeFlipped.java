package leetcode.z_Bloomberg;

/**
 * Created by qifu on 17/3/6.
 */
public class FindZerosBeFlipped {
    /*Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
    m = 2
    Output:  5 7
    We are allowed to flip maximum 2 zeroes. If we flip
    arr[5] and arr[7], we get 8 consecutive 1's which is
    maximum possible under given constraints

    Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
    m = 1
    Output:  7
    We are allowed to flip maximum 1 zero. If we flip
    arr[7], we get 5 consecutive 1's which is maximum
    possible under given constraints.

    Input:   arr[] = {0, 0, 0, 1}
    m = 4
    Output:  0 1 2
    Since m is more than number of zeroes, we can flip
    all zeroes.*/


    public static int[] flipZero(int[] nums, int m) {
        int windows_left = 0;
        int windows_right = 0;
        int num_zero = 0;
        int best_window_size = -1;
        int best_left = 0;
        int best_right = 0;
        while(windows_right < nums.length) {
            if(num_zero <= m) {
                windows_right++;
                //System.out.println(windows_right);
                if(windows_right < nums.length && nums[windows_right] == 0) {
                    num_zero++;
                }
            }

            while(num_zero > m) {


                if(windows_left < nums.length && nums[windows_left] == 0) {
                    num_zero--;
                }
                windows_left++;
                // System.out.println(num_zero+ " "+ windows_left);
            }

            //update the window
            if(num_zero == m && windows_right - windows_left > best_window_size) {
                best_window_size = windows_right - windows_left;
                best_left = windows_left;
                best_right = windows_right;
            }
        }

        int[] res = new int[m];
        int index = 0;
        //System.out.println(best_left+" " + best_right);
        for(int i = best_left; i < best_right; i++){
            //System.out.println(i);
            if(nums[i] == 0) {
                // System.out.println(index);
                res[index++] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int m = 2;

        int[] res = flipZero(arr,m);
        for(int num : res) {
            System.out.println(num);
        }
    }
}
