package leetcode.z_amazon;

import java.util.*;

public class TopN {
    public static void main(String[] args) {
        System.out.println(
                topToys(6, 2, new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
                        new String[]{
                                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                                "The new Elmo dolls are super high quality",
                                "Expect the Elsa dolls to be very popular this year, Elsa!",
                                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                                "For parents of older kids, look into buying them a drone",
                                "Warcraft is slowly rising in popularity ahead of the holiday season"
                        }));
    }

    public static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        // N log(k)  k mean topToys count
        Map<String, int[]> freq = new HashMap<>();
        for(String toy: toys) {
            freq.put(toy, new int[]{0, 0});
        }

        for(String quote: quotes) {
            Set<String> used = new HashSet<>();
            String[] words = quote.toLowerCase().split("\\W+");
            for(String word: words) {
                if (!freq.containsKey(word)) {
                    continue;
                }
                int[] nums = freq.get(word);
                nums[0]++; // count sentence
                if(!used.contains(word)) {
                    nums[1]++; // only count 1 time in each sentence
                }
                used.add(word);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>((toy1, toy2) -> {
            if (freq.get(toy1)[0] != freq.get(toy2)[0]) {
                return freq.get(toy1)[0] - freq.get(toy2)[0];
            }
            if (freq.get(toy1)[1] != freq.get(toy2)[1]) {
                return freq.get(toy1)[1] - freq.get(toy2)[1];
            }
            return toy2.compareTo(toy1);   // compare with alphabet
        });

        if (topToys > numToys) {
            for(String toy : freq.keySet()) {
                if (freq.get(toy)[0] > 0) {
                    pq.add(toy);
                }
            }
        } else {
            for(String toy : toys) {
                pq.add(toy);
                if (pq.size() > topToys) {
                    pq.poll(); // only keep topToys count
                }
            }
        }

        List<String> output = new ArrayList<>();
        while(!pq.isEmpty()) {
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;
    }


    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();
        for(String r: reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for(String s : strs) {
                s = s.toLowerCase();
                if (set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}