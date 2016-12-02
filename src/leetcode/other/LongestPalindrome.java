package leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qifu on 16/12/1.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxOdd = 0;
        int even = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(map.get(s.charAt(i)) != null){
                int num = map.get(s.charAt(i));
                num++;
                map.put(s.charAt(i), num);
            } else{
                map.put(s.charAt(i), 1);
            }
        }

        for(Character c : map.keySet()){
            //System.out.println(c +" " + map.get(c));
            if(map.get(c) % 2 == 0){
                //System.out.println("even: "+ c +" " + map.get(c));
                even += map.get(c);
            }else{
                if(map.get(c) >= maxOdd){
                    //System.out.println("1odd: "+ maxOdd +" " + map.get(c));
                    if(maxOdd != 0){
                        even += maxOdd - 1;
                    }

                    maxOdd = map.get(c);
                } else{
                    //System.out.println("2odd: "+ map.get(c));
                    even += map.get(c) - 1;
                }
                //maxOdd = Math.max(maxOdd, map.get(c));

            }
        }
        //System.out.println("Odd: "+ maxOdd);
        return maxOdd+even;


    }
    //
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return s.length() - (set.size() == 0 ? 0 : set.size() - 1);
    }

    //

    public int longestPalindrome(String s) {
        char[] alpha = new char[128];
        int sum = 0;
        if(s.length() == 0 ) return sum;

        for(char c : s.toCharArray()){
            alpha[c]++;
            if(alpha[c] == 2){
                sum += 2;
                alpha[c] = 0;
            }
        }

        if(s.length() > sum ) return sum + 1;
        else return sum;
    }

}
