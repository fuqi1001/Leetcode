package leetcode.other;

/**
 * Created by qifu on 17/1/12.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2){
        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                if(index != -1 && (word1.equals(word2) || !words[i].equals(words[index]))){
                    min = Math.min((i - index), min);
                }
                index = i;
            }

        }
        return min;
    }
}
