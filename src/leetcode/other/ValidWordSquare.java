package leetcode.other;

import java.util.List;

/**
 * Created by Crino on 2017/3/13.
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words.size() == 0 || words == null) return true;
        int n = words.size();
        for (int i = 0; i < n; i++) {
            String tmp = words.get(i);
            for (int j = 0; j < tmp.length(); j++) {
                // too long
                if (j >= n)
                    return false;
                // too short
                if (words.get(j).length() <= i)
                    return false;
                // letter not equal
                if (tmp.charAt(j) != words.get(j).charAt(i))
                    return false;
            }
        }
        return true;
    }
    //more space less time;
    public boolean validWordSquare(List<String> words) {
        int height = words.size();
        if (height==0) return false;
        int width = words.get(0).length();
        if (height!=width) return false;

        char[][] square = new char[height][width];
        for (int i=0; i<height; i++) {
            int j=0;
            for (char c: words.get(i).toCharArray()) {
                if (j==width) return false;
                square[i][j++]=c;
            }
        }

        for (int i=1; i<width; i++) {
            for (int j=0; j<i; j++) {
                //System.out.println(square[i][j] +" "+ square[j][i]);
                if (square[i][j] != square[j][i]) return false;
            }
        }

        return true;
    }
}
