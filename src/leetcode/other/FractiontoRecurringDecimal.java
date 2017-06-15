package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/6/15.
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-": "");

        long _numerator = Math.abs((long)numerator);
        long _denominator = Math.abs((long)denominator);
        long digit = _numerator / _denominator;
        sb.append(digit);
        digit = _numerator % _denominator;
        if(digit == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(digit, sb.length());
        while(digit != 0) {
            digit *= 10;
            sb.append(digit / _denominator);
            digit %= _denominator;
            if(map.containsKey(digit)) {
                int index = map.get(digit);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(digit, sb.length());
            }
        }
        return sb.toString();
    }

    /*
    用hashMap来储存每个digit的位置
    如果遇到重复的就可以开始加括号了

     */

}
