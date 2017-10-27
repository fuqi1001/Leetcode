package leetcode.z_Bloomberg;

public class removeNumber {
    static int index = 0;
    public static int[] removeNumber(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            if((i % 2 == 1) ||(i % 2 == 0 && numbers[i] % 2 == 1) ){
                numbers[index++] = numbers[i];
            }
        }
        return numbers;
    }
}
