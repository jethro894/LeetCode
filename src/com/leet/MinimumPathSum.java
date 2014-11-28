package com.leet;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if(grid.length == 0)
        	return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] minPathSum = new int[m][n];
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(i == 0 && j == 0){
        			minPathSum[i][j] = grid[i][j];
        			continue;
        		}
        		if(i == 0){
        			minPathSum[i][j] = minPathSum[i][j-1] + grid[i][j];
        			continue;
        		}
        		if(j == 0){
        			minPathSum[i][j] = minPathSum[i-1][j] + grid[i][j];
        			continue;
        		}
        		minPathSum[i][j] = Math.min(minPathSum[i][j-1], minPathSum[i-1][j]) + grid[i][j];
        	}
        }
        
        return minPathSum[m-1][n-1];
    }
}
