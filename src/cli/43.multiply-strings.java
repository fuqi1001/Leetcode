class Solution {
    public String multiply(String num1, String num2) {
	if (num1.equals("0") || num2.equals("0")) return "0";
	int len1 = num1.length();
	int len2 = num2.length();
	String res = "0";
	int appenZero = 0;
	for (int i = len1 - 1; i >= 0; i--) {
	    int curDigit = num1.charAt(i) - '0';
	    int carry = 0;
	    String cur_ans = "";
	    for (int j = len2 - 1; j >= 0; j--) {
		int curDigit2 = num2.charAt(j) - '0';
		int tempMul = curDigit * curDigit2 + carry;
		carry = tempMul / 10;
		int tail = tempMul % 10;
		cur_ans = tail + "" + cur_ans;
	    }
	    if (carry > 0) {
		cur_ans = carry + "" + cur_ans;
	    }
	    for (int p = 0; p < appenZero; p++) {
		cur_ans = cur_ans + "0";
	    }
	    appenZero++;
	    res = bigNumSum(res, cur_ans);
	}
	return res;
    }
    
    private String bigNumSum(String num1, String num2) {
	int index1 = num1.length() - 1;
	int index2 = num2.length() - 1;

	int carry = 0;
	String ans = "";

	while(index1 >= 0 || index2 >= 0) {
	    int n1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
	    int n2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
	    int sum = n1 + n2 + carry;
	    carry = sum / 10;
	    ans = sum % 10 + "" + ans;
	    index1--;
	    index2--;
	}
	if (carry > 0) {
	    ans = carry + "" + ans;
	}
	return ans;
    }
}
