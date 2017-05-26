package leetcode.other;

/**
 * Created by qifu on 16/11/19.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length(); i++) {
            for(int j = i + 1; j < num.length() - i - 1; j++) {
                String first = num.substring(0, i+1);
                String second = num.substring(i+1, j+1);
                if(isValid(num, j+1, first, second)) return true;
            }
        }
        return false;
    }

    public boolean isValid(String num, int start, String first, String second) {
        if(start == num.length()) return true;

        long _first = Long.parseLong(first);
        long _second = Long.parseLong(second);

        if(!Long.toString(_first).equals(first) || !Long.toString(_second).equals(second)) return false;

        long sum = _first + _second;
        String _sum = Long.toString(sum);

        if(start + _sum.length() > num.length()) return false;
        String third = num.substring(start, start + _sum.length());
        long _third = Long.parseLong(third);
        if(!third.equals(_sum) || sum != _third) return false;

        return isValid(num, start + _sum.length(), second, third);
    }
}
