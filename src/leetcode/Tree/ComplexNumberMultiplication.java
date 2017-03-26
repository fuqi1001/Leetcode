package leetcode.Tree;

import java.util.stream.Stream;

/**
 * Created by qifu on 17/3/25.
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] str1 = a.split("\\+");
        String[] str2 = b.split("\\+");

        // a =>
        int num_a = 0;
        if(str1[0].charAt(0) == '-') {
            num_a = -1 * Integer.valueOf(str1[0].substring(1));
        } else {
            num_a = Integer.valueOf(str1[0]);
        }

        int num_b = 0;
        if(str1[1].charAt(0) == '-') {
            num_b = -1 * Integer.valueOf(str1[1].substring(1, str1[1].length() - 1));
        } else {
            num_b = Integer.valueOf(str1[1].substring(0, str1[1].length() - 1));
        }

        // b =>
        int num_c = 0;
        if(str2[0].charAt(0) == '-') {
            num_c = -1 * Integer.valueOf(str2[0].substring(1));
        } else {
            num_c = Integer.valueOf(str2[0]);
        }
        int num_d = 0;
        if(str2[1].charAt(0) == '-') {
            num_d = -1 * Integer.valueOf(str2[1].substring(1, str2[1].length() - 1));
        } else {
            num_d = Integer.valueOf(str2[1].substring(0, str2[1].length() - 1));
        }

        //System.out.println(num_a+" "+num_b+" "+num_c+" "+num_d);
        String res = "";
        res = (num_a * num_c - num_b * num_d) + "+" + (num_a * num_d + num_c * num_b) +"i";
        return res;
    }

    //
    public String complexNumberMultiply(String a, String b) {
        int[] numa = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(),
                numb = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (numa[0]*numb[0] - numa[1]*numb[1]) +"+"+(numa[0]*numb[1] + numa[1]*numb[0])+"i";
    }
}
