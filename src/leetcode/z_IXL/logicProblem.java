package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/22.
 */
public class logicProblem {
    /*
    1. Alex said Bob break the glass
    2. Bob said Dane break the glass
    3. Chris said not him
    4. Dane said Bob is lie


    if only one lie:
    Bob is lying

    1 true
    2 fail
    3 true
    4 true
    Bob break the glass

    if only one true
    Dane is true

    1 false, so bob not break the glass
    2 false, so Dane not break the glass
    3 false, so Chris break the glass
    4 true, so Dane not break the glass

    so Chris break the glass


    1，中间只隔一个数字的两个素数，它们都不能被2整除。所以中间隔的那个数一定可以被2整除，
         因为每过一个奇数接下来都是一个偶数。
    2，这两个素数都不能被3整除，而且，第一个素数的前一个数字X也不能被3整除，因为后一个素数
         比X大3，既然该素数不能被3整除，那么自然X也就不能了；那么由于每隔两个不能被3整除的数字
         之后都会出现一个可以被3整除的数字，所以两个素数中间的那个数必然可以被3整除。
    3，由于中间该数既能被2整除，又能被3整除，所以它就能被6整除。

    以下是我的证明：
    从5、6、7开始，相邻的三个数总可以被表示成:
    5  + 6k, 6+ 6k, 7+ 6k //可能存在素数对
    6+ 6k, 7+ 6k, 8+ 6k //6 + 6k为合数，被3整除
    7+ 6k, 8+ 6k, 9+ 6k//9+6k被3整除
    8+ 6k,9+ 6k,10+ 6k//8+6k被2整除
    9+ 6k,10+ 6k,11+6k//9+6k被3整除
    10+ 6k, 11+ 6k, 12+ 6k//10+6k被2整除
    其中，k = 0,1, 2, 3, ...
    显然，以上的各组表达式中，只有第1组可能存在素数对，并且，6+6k是6的倍数。


     */
}
