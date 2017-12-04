package z_leetcode.bloomberg_onsite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class topKStock {
    class Stock {
        String name;
        int share;
        public Stock(String name, int share) {
            this.name = name;
            this.share = share;
        }
    }

    TreeSet<Stock> sett = new TreeSet<>(new Comparator<Stock>() {
        @Override
        public int compare(Stock o1, Stock o2) {
            return o2.share - o1.share;
        }
    });

    public void topKstock(String name, int share) {
        sett.add(new Stock(name, share));
        Iterator<Stock> it = sett.iterator();
        while(it.hasNext()) {
            Stock cur = it.next();
            System.out.println(cur.name+": "+cur.share);
        }
    }


    public static void main(String[] args) {
        topKStock t = new topKStock();
        t.topKstock("1", 100);
        t.topKstock("2", 200);
        t.topKstock("3", 300);
        t.topKstock("4", 400);
        t.topKstock("5", 500);
        t.topKstock("6", 600);
    }
}
