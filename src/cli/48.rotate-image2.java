class Solution {
    public void rotate(int[][] matrix) {
	if (matrix.length == 0 || matrix[0].length == 0) return;
	int n = matrix.length;
	for (int i = 0; i < n ; i++) {
	    for (int j = 0; j <= i; j++) {
		if (i == j) continue;
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	    }
	}
	

	for (int i = 0 , j = n - 1; i < n / 2; i++, j--) {
	    for (int k = 0; k < n; k++) {
		int temp = matrix[k][i];
		matrix[k][i] = matrix[k][j];
		matrix[k][j] = temp;
	    }
	}
	
    }
}