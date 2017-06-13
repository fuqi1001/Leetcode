package leetcode.other;

/**
 * Created by qifu on 16/12/11.
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(IP.contains(".")) {
            String[] str = IP.split("\\.");
            if(str.length != 4) return "Neither";
            if(IP.charAt(IP.length() - 1) == '.') return "Neither";
            for(String cur : str) {
                try {
                    Integer digit = Integer.parseInt(cur);
                    if(digit < 0 || digit > 255) return "Neither";
                    if(!cur.equals(String.valueOf(digit))) return "Neither";
                } catch(NumberFormatException ignored) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if(IP.contains(":")) {
            String[] str = IP.split(":");
            if(str.length != 8) return "Neither";
            if(IP.charAt(IP.length() - 1) == ':') return "Neither";
            for(String cur : str) {
                int len = cur.length();
                if(len < 1 || len > 4) return "Neither";
                for(int i = 0; i < len; i++) {
                    if(!isHex(cur.charAt(i))) return "Neither";
                }
            }
            return "IPv6";
        }

        return "Neither";

    }
    public boolean isHex(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
}
/*
简单分情况讨论:
1. String中包含 "." --> 有可能是IPv4
    split String 成为String数组
        如果数组中元素个数超过4 -->Neither
        如果不超过4
            如果String末尾是"." -->Neither
            如果不是
                如果String不能被parse成Integer -->Neither
                如果可以
                    如果cover成Integer后 大于255 或者小于0  -->Neither
                    如果在范围内
                        如果cover成的数字 和原string不等  -->Neither

                            --> IPv4
2. String中包含 ":" --> 有可能是IPv6
    split String 成为String数组
        如果数组中元素个数超过8 -->Neither
        如果不超过8
            如果String末尾是":" -->Neither
            如果不是
                测试每个string 的长度 如果小于1或者大于4  -->Neither
                如果再范围内
                    测试每个字符是否为hex的

 */