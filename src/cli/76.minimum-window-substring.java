class Solution {
    public String minWindow(String s, String t) {
	int start = 0;
	int start_index = -1;
	int window_len = Integer.MAX_VALUE;
	int count = 0;

	Map<Character, Integer> strMap = new HashMap<>();
	Map<Character, Integer> tarMap = new HashMap<>();

	for(char c: s.toCharArray()) {
	    strMap.put(c, 0);
	}
	for(int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    strMap.put(c, strMap.get(c) + 1);
	    if (strMap.get(c) != 0 && tarMap.get(c) < strMap.get(c)) {
		count++;
	    }
	    if (count == t.length()) {
		char cc = s.charAt(start);
		while((strMap.get(cc) > tarMap.get(cc)) || tarMap.get(cc) == 0) {
		    if (strMap.get(cc) > tarMap.get(cc)) {
			strMap.put(cc, strMap.get(cc) - 1);
		    }
		    start++;
		}
		int curLen = i - start + 1;
		if (window_len > curLen) {
		    start_index = start;
		    window_len = curLen;
		}
	    }
	}
	if (start_index == -1) return "";
	return s.substring(start_index, start_index + window_len);
    }
}
