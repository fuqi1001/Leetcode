package leetcode.z_Bloomberg;

public class CompressString {
    public static String helper(String str) {
        if(str.length() < 2) return str;
        int point = 0;
        int count = 1;
        char c = str.charAt(point);
        point++;
        StringBuilder sb = new StringBuilder();
        while(point != str.length()) {
            char cur = str.charAt(point);
            if(c == cur) {
                count++;
            } else {
                if(count > 2) {
                    sb.append(c).append("#").append(count);
                } else {
                    for(int i = 0; i < count ;i++){
                        sb.append(c);
                    }
                }
                c = cur;
                count = 1;
            }
            point++;
        }
        if(count > 2) {
            sb.append(c).append("#").append(count);
        } else {
            for(int i = 0; i < count ;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
