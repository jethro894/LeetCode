package com.leet;

public class UniquePath {
	int num_of_paths;
	public int uniquePathsBruteForce(int m, int n) {
		if(m == 0 && n == 0)
			return 0;
		
		if(m == 0 || n  == 0)
			return 1;
		
		num_of_paths = 1;
		walk(0,0,m,n);
		return num_of_paths;
    }
	
	public void walk(int i, int j, int m, int n){
		if(i == m-1 && j == n-1){
			return;
		}
		
		if(i != m-1 && j != n-1){
			num_of_paths++;
			walk(i+1, j, m, n);
			walk(i, j+1, m, n);
		}
		else{
			if(i != m-1)
				walk(i+1, j, m, n);
			else
				walk(i, j+1, m, n);
		}
	}
	
	public int uniquePaths(int m, int n){
		if(m == 0 && n == 0)
			return 0;
		
		if(m == 0 || n  == 0)
			return 1;
		
		int[][] result = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 && j == 0)
					result[i][j] = 1;
				else if(i == 0)
					result[i][j] = result[i][j-1];
				else if(j == 0)
					result[i][j] = result[i-1][j];
				else
					result[i][j] = result[i-1][j] + result[i][j-1];
			}
		}
		
		return result[m-1][n-1];
	}
}
