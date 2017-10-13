package leetcode.z_Bloomberg;

public class MoveSpace {
    public static void main(String[] args) {

        System.out.println(move("Hello this is jim fu"));
    }
    public static String move(String str) {
        char[] ctr = str.toCharArray();
        int index = 0;
        for(char c : ctr) {
            if(c != ' ') {
                ctr[index++] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < index; i++) {
            sb.append(ctr[i]);
        }
        return sb.toString();
    }
}