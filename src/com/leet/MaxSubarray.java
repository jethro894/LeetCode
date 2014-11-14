package com.leet;

public class MaxSubarray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2, 1};
		
		System.out.println(new MaxSubarray().maxSubArray(A));
	}
	
	public int maxSubArray(int[] A) {
		if(A.length == 0)
			return 0;
		
        int max_ending_here = A[0];
        int max_sofar = A[0];
        
        for(int i = 1; i < A.length; i++){
        	max_ending_here = Math.max(A[i], max_ending_here + A[i]);
        	if(max_ending_here > max_sofar)
        		max_sofar = max_ending_here;
        }
        
        return max_sofar;
    }
}
