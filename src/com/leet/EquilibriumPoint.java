package com.leet;

public class EquilibriumPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};
		System.out.print(equPoint(A));
	}
	
	public static int equPoint(int[] A){
		if(A.length == 0)
            return -1;
            
        int[] sum1 = new int[A.length];
        int[] sum2 = new int[A.length];
        
        sum1[0] = 0;
        sum2[A.length - 1] = 0;
        
        int i;
        
        for(i = 1; i < A.length; i++){
            sum1[i] = A[i-1] + sum1[i-1];
        }
        
        for(i = A.length -2; i >= 0; i--){
            sum2[i] = A[i+1] + sum2[i+1];
        }
        
        
        /*for(i = 0; i < A.length; i++){
            if(sum1[i] == sum2[i])
               return i;
        }*/
        
        for(int j : sum1)
        	System.out.print(j + ",");
        
        System.out.println();
        
        for(int j : sum2)
        	System.out.print(j + ",");
        
        System.out.println();
        
        return -1;
	}

}
