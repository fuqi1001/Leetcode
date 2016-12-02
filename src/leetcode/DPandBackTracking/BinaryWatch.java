package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/12/2.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if(num > 8){
            return res;
        }

        if(num == 0){
            String str = "0:00";
            res.add(str);
            return res;
        }

        int time[] = {8,4,2,1,32,16,8,4,2,1};

        boolean[] check = new boolean[10];
        helper(res,time,check,num,0);
        return res;
    }
    public void helper(List<String> res, int[] time, boolean[] check, int num, int start){
        if(num == 0){
            int hour = 0;
            int minute = 0;
            for(int k = 0 ; k < 10 ;k++){
                if(check[k] == true && k <= 3){
                    hour+= time[k];
                }
                if(check[k] == true && k > 3){
                    minute += time[k];
                }
            }

            if(hour >=12 || minute >= 60){
                return;
            }

            else{
                if(minute < 10){
                    String answer = ""+hour+":0"+minute;
                    res.add(answer);
                    return;
                }else{
                    String answer = ""+hour+":"+minute;
                    res.add(answer);
                    return;
                }
            }
        }

        for(int i = start ; i < time.length; i++){
            check[i] = true;
            helper(res,time,check,num - 1, i + 1);
            check[i] = false;

        }
    }
}
