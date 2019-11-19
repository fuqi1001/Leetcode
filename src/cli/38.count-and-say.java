class Solution {
    public String countAndSay(int n) {
        String res = "1";
	while(n > 1) {
	    String temp = "";
	    for(int i = 0; i < res.length(); i++){
		int count = getDupChar(res.substring(i));
		temp = temp  + count + "" + res.charAt(i);
		i = i + count  - 1;
	    }
	    n--;
	    res = temp;
	}
	return res;
    }
    private int getDupChar(String str) {
	int count = 1;
	char c = str.charAt(0);
	int index = 1;
	while(index < str.length()) {
	    if (str.charAt(index) == c) {
		count++;
		index++;
	    } else break;
	}
	return count;
    }
}
