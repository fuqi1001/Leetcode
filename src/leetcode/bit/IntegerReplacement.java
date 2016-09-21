package leetcode.bit;

/**
 * Created by qifu on 16/9/20.
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        if(n == Integer.MAX_VALUE)
            return 32;

        while(n != 1){
            if((n & 1) == 0){
                n = n >> 1;
                count++;
            }
            else{
                if(n == 3){
                    n = 2;
                }
                else{
                    if(helper(n - 1) > helper(n + 1))
                        n = n-1;
                    else
                        n = n+1;
                }
                count++;
            }

        }
        return count;
    }
    public int helper(int n ){
        int c = 0;
        while( ( n & 1) == 0){
            n = n >> 1;
            c++;
        }
        return c;
    }

    //http://blog.csdn.net/yeqiuzs/article/details/52506492
    //每遇到奇数时，分别判断n-1还是n+1的尾部零更多，越多的当然步骤越少。
    //特殊case：当n==Integer 最大值时，当n==3时
}
