package leetcode.z_IXL;

import java.util.Map;

/**
 * Created by qifu on 17/4/27.
 */
public class ZZZHuaXueFangCheng {
    public static void Element(String strs, int multi, Map<String, Integer> map) {
        int index = 0;
        String ele = "";
        while(index < strs.length()) {
            char cur = strs.charAt(index);

            if(cur >= 'A' && cur <= 'Z' ){
                index++;
                if(index < strs.length() && strs.charAt(index) >= 'a' && strs.charAt(index) <= 'z') {
                    ele = cur +""+ strs.charAt(index);
                    index++;
                } else {
                    ele = cur +"";
                }
                if(index < strs.length() && Character.isDigit(strs.charAt(index))) {
                    int num = 0;
                    while(index < strs.length() && Character.isDigit(strs.charAt(index))) {
                        num = num * 10 + (strs.charAt(index) -'0');
                        index++;
                    }
                    //System.out.println(multi);
                    map.put(ele, map.getOrDefault(ele, 0) + num * multi);
                } else {
                    map.put(ele, map.getOrDefault(ele, 0) + multi);
                }

            } else if(cur == '(') {
                index++;
                int start = index;
                int end = start;
                int count_p = 1;
                while(index< strs.length() && count_p != 0) {
                    if(strs.charAt(index) == '(' ) count_p++;
                    else if(strs.charAt(index) == ')'){
                        count_p--;
                    }
                    index++;
                    end = index-1;
                }
                //System.out.println("aaa" + index);
                int num = 0;
                if(index < strs.length() && Character.isDigit(strs.charAt(index))) {
                    while(index < strs.length() && Character.isDigit(strs.charAt(index))) {
                        num = num * 10 + (strs.charAt(index) -'0');
                        index++;
                    }
                }
                //System.out.println(start+ " " +end +" "+num +" "+ index);
                if(num != 0) {
                    Element(strs.substring(start, end),multi*num,map);
                } else {
                    Element(strs.substring(start, end),multi,map);
                }
                //System.out.println("w"+index);
            }
        }
        //System.out.println("end"+index);
    }
}
