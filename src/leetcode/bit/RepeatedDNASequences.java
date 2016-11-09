package leetcode.bit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by qifu on 16/11/8.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> hash = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for(int i = 9 ; i < s.length() ;i++){
            String str = s.substring(i - 9 , i + 1);
            int encoded = encode(str);
            if(hash.contains(encoded)){
                res.add(str);
            }else{
                hash.add(encoded);
            }
        }

        List<String> result = new ArrayList<>();
        for(String dna : res){
            result.add(dna);
        }
        return result;
    }

    public int encode(String s){
        int sum = 0;
        for(int i = 0 ; i < s.length() ;i++){
            if(s.charAt(i) == 'A'){
                sum = sum * 4;
            } else if(s.charAt(i) == 'C'){
                sum = sum * 4 + 1;
            } else if(s.charAt(i) == 'G'){
                sum = sum * 4 + 2;
            }else{
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
}
