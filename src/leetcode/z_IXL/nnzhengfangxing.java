package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/21.
 */
public class nnzhengfangxing {
    /*
    给一个正方形的边长,问这个正方形里面能包含多少个其他尺寸的正常行
    如一个4*4的正方形，
    考虑包含的1*1,有 4*4个，
    2*2的正方形，一个边上能放3个不同的正方形，则大正方形内能放有3*3个2*2的小正方形
    同理，能放2*2个3*3的小正方形，
    能放1*1个4*4的正方形。
    所以结果是 1^2 + 2^2 + 3^2 + 4^2 ;
    平方和公式 n(n+1)(2n+1)/6
     */

    public int square(int n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    /*
    For example, for a 4 multi 4 square

    we can put 4 different 1 multi 1 square in each edge,
    at the end we can put 4*4 little squares in the large square

    and we can put 3 different 2 multi 2 square in each edge,
    at the end we can put 3*3 little squares in the large square

    and we also can put 2 different 3 * 3 square in each edge,
    get 2 * squares in the large on

    and we put 1 square in each with 4*4


    finally we get 1 + 4 + 9 + 16
    get 1^2 + 2^2 + 3^2 + 4^2
    2 power of 1 plus 2 power of 2 ````
    and the i learn the sum of squares in middle school
    we can get a equation to solve the problem

     */
}
