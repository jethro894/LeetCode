package com.leet;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {2,2,3,4,6,7,8,10,12,13,13,15};
		int[] B = {1,1,2,3,5,5,6,8,9,13,16};
		MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
		System.out.println(motsa.findMedianSortedArrays(A, B));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int i = A.length;
        int j = B.length;
        
        if(i == 0)
        	if(j != 0)
        		return (double)B[(j - 1)/2];
        if(j == 0)
        	if(i != 0)
        		return (double)A[(i - 1)/2];
        
        int m = (i + j - 1)/2;
        
        int k = 0; 
        int l = 0;
        while(k + l + 2 != m + 1){
        	if(k + l + 2 < m + 1){
        		if(A[k] == B[l]){
        			k += (i - 1 -k)/2;
        			l += (j - 1 -l)/2;
        		}
        		else if(A[k] < B[l])
        			k += (i - 1 -k)/2;
        		else
        			l += (j - 1 -l)/2;
        	}
        	else{
        		if(A[k] == B[l]){
        			k /= 2;
        			l /= 2;
        		}
        		else if(A[k] < B[l])
        			l /= 2;
        		else
        			k /= 2;
        	}
        }
        int median1 = Math.max(A[k], B[l]);
        if( (i + j) % 2 == 1)
        	return (double) median1;
        
        int median2;
        if(A[k] > B[l])
        	median2 = Math.min(A[k+1], B[l]);
        else
        	median2 = Math.max(A[1], B[l+1]);
        
        return ((double)median1 + (double)median2)/2;

    }

}
