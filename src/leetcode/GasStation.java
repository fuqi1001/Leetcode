package leetcode;

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
}
