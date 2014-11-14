package com.leet;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix.length == 0)
			return;
		
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rows_to_be_cleared = new int[m];
        int[] columns_to_be_cleared = new int[n];
        
        for(int i = 0; i < m; i++){
        	for(int j =0; j < n; j++){
        		if(matrix[i][j] == 0){
        			if(rows_to_be_cleared[i] != 1)
        				rows_to_be_cleared[i] = 1;
        			if(columns_to_be_cleared[j] != 1)
        				columns_to_be_cleared[j] = 1;
        		}
        	}
        }
        
        for(int i = 0; i < m; i++){
        	if(rows_to_be_cleared[i] == 1){
        		for(int j =0; j < n; j++){
            		matrix[i][j] = 0;
            	}
        	}else{
        		for(int j =0; j < n; j++){
        			if(columns_to_be_cleared[j] == 1)
            		matrix[i][j] = 0;
            	}
        	}
        }
    }
}
