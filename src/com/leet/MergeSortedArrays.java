package com.leet;

public class MergeSortedArrays {
	public void merge(int A[], int m, int B[], int n) {
        if(n == 0)
            return;
        
        int curT = m+n -1;
        int curA = m - 1;
        int curB = n - 1;
        
        while(curT >= 0){
            if(curA < 0){
                A[curT] = B[curB];
                curB--;
                curT--;
                continue;
            }
            
            if(curB < 0)
                break;
            
            if(A[curA] >= B[curB]){
                A[curT] = A[curA];
                curA--;
                curT--;
            }else{
                A[curT] = B[curB];
                curB--;
                curT--;
            }
        }
    }
}
