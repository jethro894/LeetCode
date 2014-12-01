package com.leet;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList<Integer>();
		
        if(matrix.length == 0 || matrix[0].length == 0)
        	return spiral;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ml = 0;
        int mh = m-1;
        
        int nl = 0;
        int nh = n-1;
        
        while(ml <= mh && nl <= nh){
        	for(int j = nl; j <= nh; j++){
        		spiral.add(matrix[ml][j]);
        	}
        	
        	ml++;
        	if(ml > mh)
        	    break;
        	
        	for(int i = ml; i <= mh; i++){
        		spiral.add(matrix[i][nh]);
        	}
        	
        	nh--;
        	if(nl > nh)
        	    break;
        	
        	for(int j = nh; j >= nl; j--){
        		spiral.add(matrix[mh][j]);
        	}
        	
        	mh--;
        	if(ml > mh)
        	    break;
        	
        	for(int i = mh; i >= ml; i--){
        		spiral.add(matrix[i][nl]);
        	}
        	nl++;
        }
        
        return spiral;
    }
}
