package z_leetcode.bloomberg_onsite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Joseph {
     public static int showJoseph(int total, int cycle, int start) {
         boolean[] check = new boolean[total];
         Arrays.fill(check, true);
         int kill = 0;
         int index = start - 1;
         int result = 0;

         while(kill < total) {
             for(int i = 0; i < cycle; i++) {
                 while(!check[index]) {
                     index = (index + 1) % total;
                 }
                 if(i == cycle - 1) {
                     System.out.print((index+1) + (kill < total - 1 ? " " : "\n"));
                     check[index] = false;
                     kill++;
                 }

                 if(kill == total - 1) result = index + 1;
                 index = (index + 1) % total;
             }
         }
        return result;
     }
     //带方向
    private static int showJoseph(int total, int cycle, int start, boolean forward) {
        boolean[] arr = new boolean[total];
        Arrays.fill(arr, true);
        int kill = 0;
        int index = start - 1;
        int result = 0;

        while (kill < total) {
            for (int i = 0; i < cycle; i++) {
                while (!arr[index]) {
                    if (forward) {
                        index = (++index + total) % total;
                    } else {
                        index = (--index + total) % total;
                    }
                }
                if (i == cycle - 1) {
                    System.out.print(index + 1 + (kill < total - 1 ? " " : "\n"));
                    arr[index] = false;
                    kill++;
                }
                if(kill==total-1) result = index+1;
                if (forward) {
                    index = (++index + total) % total;
                } else {
                    index = (--index + total) % total;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int suvivor = showJoseph(8, 5,3);
        System.out.println("幸存者为："+suvivor);
    }


    public static void senario2(int total, int cycle) {
        List<Integer> people = new LinkedList<Integer>();
        for(int i = 1; i <= total; i++) {
            people.add(i);
        }
        int i = 0;
        for(int n = 1; n < total; n++) {
            i = (i + cycle - 1) % people.size();
            System.out.print(people.get(i) + (n == total - 1 ? "\n" : " "));
            people.remove(i);
        }
        System.out.println("幸存者" + people.get(0));
    }
}
