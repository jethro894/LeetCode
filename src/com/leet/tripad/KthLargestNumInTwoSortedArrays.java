package com.leet.tripad;

public class KthLargestNumInTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6};
		int[] B = {2,2,3,6,8,13};
		
		System.out.println(new KthLargestNumInTwoSortedArrays().kthLargest(A, B, 2));
	}
	
	public int kthLargest(int[] A, int[] B, int k){
		if(k > A.length + B.length)
			return -1;
		if(A.length == 0)
			return B[k-1];
		if(B.length == 0)
			return A[k-1];
		
		int i = 0;
		int j = 0;
		int count = 0;
		
		int a,b;
		while(i < A.length || j < B.length){
			a = i < A.length ? A[i] : Integer.MAX_VALUE;
			b = j < B.length ? B[j] : Integer.MAX_VALUE;
			
			count++;
			if(a <= b){
				if(count == k)
					return A[i];
				i++;
			}else{
				if(count == k)
					return B[j];
				j++;
			}
		}
		return -1;
	}

}
