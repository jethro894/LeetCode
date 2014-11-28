package com.leet;

public class UniquePathII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid.length == 0)
			return -1;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] result = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(obstacleGrid[i][j] == 1)
					result[i][j] = 0;
				else{
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
		}
		
		return result[m-1][n-1];
    }
}
