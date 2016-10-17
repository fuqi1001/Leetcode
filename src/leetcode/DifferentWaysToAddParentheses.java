package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/16.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < input.length() ; i++){
            if(input.charAt(i) =='+' || input.charAt(i) == '-' || input.charAt(i) =='/'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));

                for(int j = 0 ; j < left.size() ; i++){
                    for(int k = 0 ; k < right.size() ;k++){
                        if(input.charAt(i) =='+'){
                            result.add(left.get(j)+right.get(k));
                        }
                        else if(input.charAt(i) =='-'){
                            result.add(left.get(j) - right.get(k));
                        }
                        else{
                            result.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
