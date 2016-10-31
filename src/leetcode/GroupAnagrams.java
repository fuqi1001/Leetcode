package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qifu on 16/10/30.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            char[] arr = new char[26];
            for(int i = 0 ; i < str.length(); i++){
                arr[str.charAt(i) - 'a']++;
            }

            String num = new String(arr);

            if(map.containsKey(num)){
                map.get(num).add(str);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(num,temp);
            }
        }
        res.addAll(map.values());
        return res;
    }
}
