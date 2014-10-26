package com.leet;

public class MaxSubarrayProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-4,-3,-2};
		
		System.out.println(maxProduct(A));
	}

	public static int maxProduct(int[] A) {
		if(A.length == 0)
			return 0;
		
		int maxEndingHere = A[0];
		int minEndingHere = A[0];
		int maxSoFar = A[0];
		int maxTemp;
		
        for(int i = 1; i < A.length; i++){
        	maxTemp = maxEndingHere;
        	maxEndingHere = Math.max(Math.max(A[i], maxEndingHere*A[i]), minEndingHere*A[i]);
        	minEndingHere = Math.min(Math.min(A[i], maxTemp*A[i]), minEndingHere*A[i]);
        	maxSoFar = Math.max(maxEndingHere, maxSoFar);
        	
        	System.out.print(maxEndingHere + " ");
        	System.out.print(minEndingHere + " ");
        	System.out.println(maxSoFar);
        }
        
        return maxSoFar;
    }
}
