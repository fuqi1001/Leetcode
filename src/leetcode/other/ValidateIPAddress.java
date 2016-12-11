package leetcode.other;

/**
 * Created by qifu on 16/12/11.
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            String[] IPs = IP.split("\\.");
            if (IPs.length != 4) return "Neither";
            for (int i = 0; i < 4; i++) {
                try {
                    int digit = Integer.parseInt(IPs[i]);

                    if (digit < 0 || digit > 255) return "Neither";

                    if (!IPs[i].equals(String.valueOf(digit))) return "Neither";

                } catch (NumberFormatException ignored) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (IP.contains(":")) {
            String[] IPss = IP.split(":");
            if (IPss.length != 8) return "Neither";

            if (IPss.length == 0) return "Neither";
            for (int i = 0; i < 8; i++) {
                String temp = IPss[i];
                if (temp.length() < 1 || temp.length() > 4) return "Neither";

                for (char c : temp.toCharArray()) {
                    if (!isHex(c)) {
                        System.out.println(c);
                        return "Neither";

                    }
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }


    }

    public boolean isHex(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
}
