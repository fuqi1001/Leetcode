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

        int res = 1;
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        start.add(beginWord);
        end.add(endWord);

        while(!start.isEmpty()) {
            if(start.size() > end.size()) {
                Set<String> temp = new HashSet<>();
                temp = start;
                start = end;
                end = temp;
            }

            Set<String> next = new HashSet<>();
            for(String word : start) {
                char[] _word = word.toCharArray();
                for(int i = 0; i < _word.length; i++) {
                    char prev = _word[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        _word[i] = c;
                        String _new = String.valueOf(_word);
                        if(end.contains(_new)) return res+1;
                        if(wordSet.contains(_new)) {
                            wordSet.remove(_new);
                            next.add(_new);
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

    /*
    创建三个SET 分别存词典, start词, end词
    对start词中进行遍历,寻找改变单个字母课变为wordset中词的 string
    将其从wordSet中remove 放入next中
    在循环最后将next覆给start

    start 与 end set的交换是为了竟可能少的遍历
     */
}
