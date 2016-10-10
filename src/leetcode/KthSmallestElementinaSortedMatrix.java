package leetcode;

import java.util.Arrays;

/**
 * Created by qifu on 16/10/10.
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] res = new int[len*len];
        int index = 0;
        for(int i = 0 ; i < len ;i++){
            for(int j = 0 ; j < len ; j++){
                res[index] = matrix[i][j];
                index++;
            }
        }
        Arrays.sort(res);
        return res[k];
    }

    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int L = matrix[0][0];
        int R = matrix[n-1][n-1];

        while(L < R){
            int mid = L+((R-L) >> 1);
            int temp = search_lower_than_mid(matrix,n,mid);
            if(temp < k){
                L = mid + 1;
            }
            else{
                R = mid;
            }

        }
        return L;
    }
    public int search_lower_than_mid(int[][] matrix ,int n ,int x){
        int i = n - 1;
        int j = 0;
        int cnt = 0;

        while(i >= 0 && j < n){
            if(matrix[i][j] <= x){
                j++;
                cnt += i+1;
            }
            else i--;
        }
        return cnt;
    }
}