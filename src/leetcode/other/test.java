package leetcode.other; /**
 * Created by qifu on 16/1/28.
 */

public class test {


    public static void main(String[] args){
        for(int i = 0; i <= 3 ;i++){
            System.out.println("output one");
            for(int j = 0 ; j <=10 ; j++){
                if(j == 3) break;
                System.out.println("output two");
            }
        }
    }
}