package leetcode;

/**
 * Created by qifu on 16/10/24.
 */
public class ReconstructOriginalDigitsfromEnglish {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(char c : s.toCharArray()){
            switch (c){
                case 'z':
                    count[0]++;
                    break;
                case 'o':
                    count[1]++;
                    break;
                case 'w':
                    count[2]++;
                    break;
                case 'h':
                    count[3]++;
                    break;
                case 'u':
                    count[4]++;
                    break;
                case 'f':
                    count[5]++;
                    break;
                case 'x':
                    count[6]++;
                    break;
                case 's':
                    count[7]++;
                    break;
                case 'g':
                    count[8]++;
                    break;
                case 'i':
                    count[9]++;
                    break;
                default:
            }
        }

        count[5] -= count[4];
        count[3] -= count[8];
        count[7] -= count[6];
        count[1] -= count[4]+ count[2]+ count[0];
        count[9] -= count[5]+count[6]+count[8];
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < 10;i++){
            for(int j =0 ;j < count[i] ;j++){
                res.append(i);
            }
        }
        return res.toString();
    }
}
