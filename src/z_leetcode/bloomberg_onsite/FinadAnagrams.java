package z_leetcode.bloomberg_onsite;


import java.util.*;

/*
有一个word的dictionary（非python的那个dictionary），
从里面找到所有given string a的anagrams。
 */
public class FinadAnagrams {
    static Set<String> set = new HashSet<>();

    public static void coverString(String str) {
        String after = coverStr(str)+"#"+str;
        System.out.println(coverStr(str));
        if(!set.contains(after)) {
            set.add(after);
        }
    }

    public static String coverStr(String str) {
        int[] countStr = new int[26];

        for(char c : str.toCharArray()) {
            countStr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(countStr[i] > 0) {
                sb.append((char)('a'+i)).append(countStr[i]);
            }
        }
        return sb.toString();
    }

    public static List<String> findAna(String[] dic, String target) {
        String coveredTarget = coverStr(target);
        for(String cur : dic) {
            coverString(cur);
        }
        List<String> list = new ArrayList<>();
        for(String cur : set) {
            String[] strArray = cur.split("#");
            System.out.println(cur);
            if(strArray[0].equals(coveredTarget)) {
                list.add(strArray[1]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String[] str = {"abc","bca","cab", "cba", "acb","bac"};

        System.out.println(findAna(str, "abc"));
    }

}
