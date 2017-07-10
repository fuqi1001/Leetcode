package leetcode.other;

/**
 * Created by qifu on 17/7/10.
 */
public class SolvetheEquation {
    public String solveEquation(String equation) {
        if(equation == null) return "No solution";

        int num_x = 0;
        int num_n = 0;

        int xsfh = 1;
        int csfh = -1;

        int symbol = 1;

        int num = 0;
        boolean zero = true;

        int index = 0;  //use to keep symbol
        char[] temp = new char[260];

        for(int i = 0; i < equation.length(); i++) {
            char cur = equation.charAt(i);
            num = 0;
            while(cur >= '0' && cur <= '9') {
                num = num * 10 + (cur - '0');
                if(num == 0) zero = false;
                if(i < equation.length() - 1) {
                    i++;
                    cur = equation.charAt(i);
                } else {
                    break;
                }
            }

            temp[index++] = cur;
            if(index > 1) {
                symbol = (temp[index - 2] == '-' ? -1 : 1);
            }
            if(cur == 'x') {
                if(num == 0 && zero) num = 1;
                num_x = num_x + num * xsfh * symbol;
            } else {
                num_n = num_n + num * csfh * symbol;

                if(cur == '=') {
                    xsfh = -1;
                    csfh = 1;
                }
            }
        }
        if(num_x != 0) {
            return "x="+ String.valueOf(num_n/num_x);
        } else {
            if(num_n == 0) return "Infinite solutions";
            else return "No solution";
        }
    }
}
