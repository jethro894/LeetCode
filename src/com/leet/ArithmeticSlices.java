package com.leet;

public class ArithmeticSlices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3){
        	return 0;
        }
        
        int n = A.length;
        
        int res = 0;
        int[] dp = new int[n];
        
        for(int i = 2; i < n; i++){
        	if(A[i]-A[i-1]== A[i-1]-A[i-2]){
        		dp[i] = dp[i-1]+1;
        	}
        	res += dp[i];
        }
        
        return res;
    }

}
