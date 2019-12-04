class Solution {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		int len1 = num1.length();
		int len2 = num2.length();
		int[] res = new int[len1 + len2];
		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int mulVal = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int sum = mulVal + res[i + j + 1];
				res[i + j] += sum / 10;
				res[i + j + 1] = sum % 10;
			}
		}
		for (int i = 0; i < len1 + len2; i++) {
			if (i == 0 && res[i] == 0) {
				continue;
			}
			sb.append(res[i]);
		}
		return sb.toString();
	}
}
