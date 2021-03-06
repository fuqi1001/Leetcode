package leetcode.other;

/**
 * Created by qifu on 16/11/11.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int tot = 0;
        int j = -1;
        for(int i = 0 ; i < gas.length ;i++){
            sum += gas[i] - cost[i];
            tot += gas[i] - cost[i];
            if(sum < 0){
                j = i;
                sum = 0;
            }
        }
        if(tot < 0) return -1;
        return j + 1;
    }
    /*
     <note里表示只有唯一解>
     http://bangbingsyb.blogspot.com/2014/11/leetcode-gas-station.html
    性质1. 对于任意一个加油站i，假如从i出发可以环绕一圈，则i一定可以到达任何一个加油站。显而易见。

    性质2. 如果这样的i是唯一的，则必然不存在j!=i， 从j出发可以到达i。

    反证法：如果存在这样的j，则必然存在j->i->i的路径，而这个路径会覆盖j->j一周的路径。那么j也将是一个符合条件的起点。与唯一解的限制条件矛盾。

    性质3. 假如i是最后的解，则由1可知，从0 ~ i-1出发无法达到i。而从i出发可以到达i+1 ~ n-1。

    结合以上三条性质，得出解决的思路：

    0. 如果对所有加油站的sum(gas[i] - cost[i])<0，则无解。否则进入1。

    1. 从0开始计算sum(gas[i] - cost[i])，当遇到i1使sum<0时，说明从0出发无法到达i1。
    根据性质1，0不是起始点。而由于从0出发已经到达了1 ~ i1-1。
    根据性质2，1 ~ i1-1一定不是正确的起始点。此时i1为起始点的候选。

    2. 将sum清0，并从i1出发，假如又遇到i2使sum(gas[i] - cost[i]) < 0 时
    ，说明i1出发无法绕一圈，更具性质1，排除i1。又因为i1+1 ~ i2-1都能从i1出发到达,
    。根据性质2，它们也必然不是起始点。此时i2为起始点的候选。

    3. 以此类推，直到遇到ik，使从ik出发可以到达ik+1 ~ n-1。
     */
}
