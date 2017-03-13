package leetcode.other;

import java.util.HashSet;

/**
 * Created by qifu on 16/8/30.
 */
public class HappyNumber {
    //floyd 判圈,必然循环
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = helper(slow);
            fast = helper(helper(fast));
        } while(slow != fast);      //floyd判圈
        if(slow == 1) return true;
        else return false;
    }
    public int helper(int num) {
        int sum = 0;
        while(num != 0) {
            sum += (num % 10) *(num % 10);
            num /= 10;
        }
        return sum;
    }




    //

    public boolean isHappy(int n) {
        if(n < 5){
            if(n == 1) return true;
            else
                return false;
        }
        int res = 0;
        while(n >= 1){
            res += (n%10)*(n%10);
            // System.out.println("***" + res);
            n /= 10;
        }
        return isHappy(res);
    }

    //
    public int getHappyNum(int n ){
        int sum = 0;
        while(n != 0){
            sum += (n % 10)*(n % 10);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n){
        HashSet<Integer> hash = new HashSet<Integer>();
        while(n!=1){
            if(hash.contains(n)){
                return false;
            }

            hash.add(n);
            n = getHappyNum(n);
        }
        return true;
    }
}
