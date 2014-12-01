package com.leet;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if(n < 0)
        	return null;
        
        int[][] result = new int[n][n];
        int count = 1;
        
        int ml = 0;
        int mh = n-1;
        
        int nl = 0;
        int nh = n-1;
        
        while(ml <= mh && nl <= nh){
        	for(int j = nl; j <= nh; j++)
        		result[ml][j] = count++;
        	
        	ml++;
        	if(ml > mh)
        	    break;
        	
        	for(int i = ml; i <= mh; i++)
        		result[i][nh] = count++;
        	
        	nh--;
        	if(nl > nh)
        	    break;
        	
        	for(int j = nh; j >= nl; j--)
        		result[mh][j] = count++;
        	
        	mh--;
        	if(ml > mh)
        	    break;
        	
        	for(int i = mh; i >= ml; i--)
        		result[i][nl] = count++;

        	nl++;
        }
        
        return result;
    }
}
