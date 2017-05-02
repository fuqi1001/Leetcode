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

    public int integerReplacement(int n) {
        int count = 0;
        while(n != 1) {
            if((n&1) == 0) {
                n >>>= 1;
            } else if(n == 3 || ((n>>>1)&1) == 0){
                --n;
            } else {
                ++n;
            }
            count++;
        }
        return count;
    }
    /*
    改进
    可以不需要写help函数
    只要保证 选择 n+1 或者 n-1中  1少的那个  可以用Integer.bitCount
    也可以直接对当前数字最后两位进行操作来判断
    如果是 01 ->则进行 -1操作 可得到00 是的1的总数更少
    如果是 11 ->则进行 +1操作 至少会与-1操作 得到相同数量的1 或者更好
        11111 +1  => 100000
        11111 -1  => 11110
     */
}
