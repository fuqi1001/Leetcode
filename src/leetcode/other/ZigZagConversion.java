package leetcode.other;

/**
 * Created by qifu on 16/9/22.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows<=0) return "";

        if(numRows == 1) return s;

        int size = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < numRows ; i++){
            for(int j = i ; j < s.length() ;j+=size){
                result.append(s.charAt(j));
                if(i != numRows-1 && i != 0){
                    int temp = j + size - 2*i;
                    if(temp < s.length()){
                        result.append(s.charAt(temp));
                    }
                }
            }
        }
        return result.toString();
    }
}
