package leetcode.other;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 17/2/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)) return 0;

        Set<String> wordSet = new HashSet<String>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();

        start.add(beginWord);
        end.add(endWord);

        int res = 1;
        wordSet.remove(beginWord);
        wordSet.remove(endWord);


        while(!start.isEmpty()){
            if(start.size() > end.size()){
                Set<String> temp = start;
                start = end;
                end = temp;
            }
            Set<String> next = new HashSet<>();

            for(String word : start){
                char[] strArray = word.toCharArray();
                for(int i = 0; i < strArray.length; i++){
                    char old = strArray[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        strArray[i] = c;
                        String newStr = String.valueOf(strArray);
                        if(end.contains(newStr)){
                            return res + 1;
                        }
                        if(wordSet.contains(newStr)){
                            next.add(newStr);
                            wordSet.remove(newStr);
                        }
                    }
                    strArray[i] = old;
                }
            }
            start = next;
            res++;
        }
        return 0;
    }
}
