package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/11/30.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            if(i % 3 == 0 && i % 5 == 0){
                res.add("FizzBuzz");
            } else if(i % 3 == 0){
                res.add("Fizz");
            } else if(i % 5 == 0){
                res.add("Buzz");
            } else{
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    //follow up
    public List<String> fizzBuzz(int n) {
        int fizz = 0;
        int buzz = 0;
        List<String> res = new ArrayList<>();

        for(int i = 1; i <= n ; i++) {
            fizz++;
            buzz++;
            if(fizz == 3 && buzz == 5) {
                fizz = 0;
                buzz = 0;
                res.add("FizzBuzz");
            } else if(fizz == 3) {
                fizz = 0;
                res.add("Fizz");
            } else if(buzz == 5) {
                buzz = 0;
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
