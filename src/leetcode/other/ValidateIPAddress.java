package leetcode.other;

/**
 * Created by qifu on 16/12/11.
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(IP.contains(".")) {
            String[] ip4 = IP.split("\\.");
            if(ip4.length != 4) return "Neither";
            if(IP.charAt(IP.length() - 1) == '.') return "Neither";

            int index = 0;

            for(String cur : ip4) {

                try {
                    int digit = Integer.parseInt(cur);
                    if(digit < 0 || digit > 255) {
                        //System.out.println("1");
                        return "Neither";
                    }
                    if(!ip4[index++].equals(String.valueOf(digit))){
                        //System.out.println("2");
                        return "Neither";

                    }
                } catch(NumberFormatException ignored){
                    return "Neither";
                }
            }
            return "IPv4";

        } else if(IP.contains(":")){
            String[] ip6 = IP.split(":");
            if(ip6.length != 8) return "Neither";
            if(IP.charAt(IP.length() - 1) == ':') return "Neither";

            for(String str : ip6) {
                if(str.length() < 1 || str.length() > 4) return "Neither";

                for(int i = 0; i < str.length(); i++){
                    if(!isHex(str.charAt(i))) return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
    private boolean isHex(char c){
        return (c >= '0' && c <='9') || ( c >= 'a' && c <= 'f' ) ||(c >= 'A' && c <='F') ;
    }
}
