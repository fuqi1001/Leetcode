class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
	List<Integer> res = new ArrayList<>();
	int wordNum = words.length;
	if (wordNum == 0) return res;
	int wordLen = words[0].length();
	HashMap<String, Integer> wordCount = new HashMap<>();
	for(String word: words) {
	    int value = wordCount.getOrDefault(word, 0);
	    wordCount.put(word, value + 1);
	}
	for (int i = 0 ; i < wordLen; i++) {
	    HashMap<String, Integer> wordRecord = new HashMap<>();
	    int num = 0;
	    for(int j = i; j < s.length() - wordNum * wordLen + 1; j = j + wordLen) {
		boolean hasRemoved = false;
		while(num < wordNum) {
		    String curWord = s.substring(j + num * wordLen, j + (num+1) * wordLen);
		    if (wordCount.containsKey(curWord)) {
			int value = wordRecord.getOrDefault(curWord, 0);
			wordRecord.put(curWord, value + 1);
			if (wordCount.get(curWord) < wordRecord.get(curWord)) {
			    hasRemoved = true;
			    int numRemoved = 0;
			    while(wordRecord.get(curWord) > wordCount.get(curWord)) {
				String removedWord = s.substring(j + numRemoved * wordLen, j + (numRemoved + 1) * wordLen);
				int v = wordRecord.get(removedWord);
				wordRecord.put(removedWord, v - 1);
				numRemoved++;
			    }
			    num = num - numRemoved + 1;
			    j = j + (numRemoved - 1) * wordLen;
			    break;
			}
		    } else {
			j = j + num * wordLen;
			wordRecord.clear();
			num = 0;
			break;
		    }
		    num++;
		}
		if (num == wordNum) {
		    res.add(j);
		}
		if (num > 0 && !hasRemoved) {
		    String pendingRemove = s.substring(j, j + wordLen);
		    int v = wordRecord.get(pendingRemove);
		    wordRecord.put(pendingRemove, v - 1);
		    num -= 1;
		}
	    }
	}
	return res;
    }
}
