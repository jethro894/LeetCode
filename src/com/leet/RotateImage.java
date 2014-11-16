package com.leet;
public class RotateImage {
	public static void main(String[] args){
		int[][] matrix = {{1,2},{3,4}};
		new RotateImage().rotate(matrix);
	}
	public void rotate(int[][] matrix) {
        if(matrix.length == 0)
        	return;
        int m = matrix.length;
        
        int[][] rotated = new int[m][m];
        
        for(int j = m-1; j >= 0; j--){
        	for(int i = 0; i < m; i++){
        		rotated[i][j] = matrix[m - 1 -j][i];
        	}
        }
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < m; j++ )
                matrix[i][j] = rotated[i][j];
    }
}
