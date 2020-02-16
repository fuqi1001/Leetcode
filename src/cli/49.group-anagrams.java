class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
	List<List<String>> res = new ArrayList<>();
	if (strs.length == 0) return res;
	Map<String, List<String>> map = new HashMap<>();
	for (String str: strs) {
	    char[] chr = str.toCharArray();
	    Arrays.sort(chr);
	    String temp = String.valueOf(chr);
	    if (map.containsKey(temp)) {
		map.get(temp).add(str);
	    } else {
		List<String> t = new ArrayList<>();
		t.add(str);
		map.put(temp, t);
	    }
	}
	for(Map.Entry<String, List<String>> e: map.entrySet()) {
	    res.add(e.getValue());
	}
	return res;
    }
}
