package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 16/12/4.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings){
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strings.length; i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0 ; j < strings[i].length(); j++){
                sb.append(Integer.toString(((strings[i].charAt(j) - strings[i].charAt(0) + 26)%26 )));
                sb.append(" ");
            }

            String shift = sb.toString();
            if(map.containsKey(shift)){
                map.get(shift).add(strings[i]);
            } else{
                List<String> temp = new ArrayList<>();
                temp.add(strings[i]);
                map.put(shift, temp);
            }
        }

        for(String s : map.keySet()){
            Collections.sort(map.get(s));
            result.add(map.get(s));
        }
        return result;
    }
}
