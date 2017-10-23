package leetcode.z_Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class sortAList {
    public void sortList(List<Integer> list) {
        if(list.size() <= 1) return;
        List<Integer> list_a = new ArrayList<>();
        List<Integer> list_b = new ArrayList<>();
        int a = list.size() - 1;
        int b = list.size() - 2;

        while(b >= 0) {
            int numa = list.get(a);
            int numb = list.get(b);
            if(numa > numb) {
                list_a.add(numa);
                list_b.add(numb);
            } else {
                list_a.add(numa);
                list_a.add(numb);
            }
            a--;b--;
        }

    }
}
