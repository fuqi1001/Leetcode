package leetcode.Implement;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 16/11/30.
 */
public class LoggerRateLimiter {
    List<String>[] lists;
    int[] times;

    public LoggerRateLimiter(){
        lists = new LinkedList[10];
        times = new int[10];
        for(int i = 0 ; i < 10; i++){
            lists[i] = new LinkedList<String>();
        }
    }

    public boolean shouldPrintMessage(int timestamp, String message){
        for(int i = 0; i < timestamp; i++){
            if(timestamp - times[i] < 10 && lists[i].contains(message)){
                return false;
            }
        }

        int index = timestamp % 10;
        if(times[index] == timestamp){
            lists[index].add(message);
        }
        else{
            lists[index].clear();
            lists[index].add(message);
            times[index] = timestamp;
        }
        return true;
    }
}
