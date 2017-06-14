package leetcode.other;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 17/2/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();

        start.add(beginWord);
        end.add(endWord);

        int res = 1;
        wordList.remove(beginWord);
        wordList.remove(endWord);

        while(!start.isEmpty()) {
            if(start.size() > end.size()) {
                Set<String> temp = start;
                start = end;
                end = temp;
            }

            Set<String> next = new HashSet<>();
            for(String word : start) {
                char[] _word = word.toCharArray();
                for(int i = 0; i < _word.length; i++) {
                    char prev = _word[i];
                    for(char c = 'a' ; c <= 'z'; c++) {
                        _word[i] = c;
                        String new_word = String.valueOf(_word);
                        if(end.contains(new_word)) return res + 1;
                        if(wordSet.contains(new_word)) {
                            wordSet.remove(new_word);
                            next.add(new_word);
                        }
                    }
                    _word[i] = prev;
                }
            }

            start = next;
            res++;
        }
        return 0;
    }
}
