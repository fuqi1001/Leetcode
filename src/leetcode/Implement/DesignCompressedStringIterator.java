package leetcode.Implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qifu on 17/6/11.
 */
public class DesignCompressedStringIterator {
    //two list
    List<Character> chars = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();
    int ptr = 0;

    public StringIterator(String str) {
        int i = 0;
        while (i < str.length()) {
            chars.add(str.charAt(i));
            int j = i + 1;
            while (j < str.length() && Character.isDigit(str.charAt(j))) j++;
            counts.add(Integer.parseInt(str.substring(i + 1, j)));
            i = j;
        }
    }

    public char next() {
        if (!hasNext()) return ' ';

        char result = chars.get(ptr);
        counts.set(ptr, counts.get(ptr) - 1);
        if (counts.get(ptr) == 0) ptr++;
        return result;
    }

    public boolean hasNext() {
        return ptr < chars.size();
    }

    //object
    class Pair {
        int count;
        char c;
        public Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
    Queue<Pair> que;
    public StringIterator(String compressedString) {
        que = new LinkedList<>();
        char c = ' ';
        int num = 0;
        for(char cur : compressedString.toCharArray()) {
            if(cur >= '0' && cur <= '9') {
                num = num * 10 + (cur - '0');
            } else {
                que.add(new Pair(num, c));
                num = 0;
                c = cur;
            }
        }
        if(c != ' ') {
            que.add(new Pair(num, c));
        }
        que.poll();
        for(Pair cur : que) {
            System.out.println(cur.c +" "+ cur.count);
        }
    }

    public char next() {
        if(que.isEmpty()) {
            return ' ';
        } else {
            char res = ' ';
            Pair cur = que.peek();
            res = cur.c;
            if(cur.count == 1) {
                que.poll();
            } else {
                que.peek().count--;

            }
            return res;
        }
    }
    public boolean hasNext() {
        return !que.isEmpty();
    }
}
