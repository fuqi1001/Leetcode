package leetcode.other;

/**
 * Created by qifu on 16/12/1.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index = -1;
        int minDis = Integer.MAX_VALUE;

        for(int i = 0 ; i < words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                if(index != -1 && !words[index].equals(words[i])){
                    minDis = Math.min(minDis, i - index);
                }
                index = i;
            }
        }
        return minDis;
    }
}
