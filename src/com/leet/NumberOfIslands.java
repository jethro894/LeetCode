package com.leet;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[]{
				"11000",
				"11000",
				"00100",
				"00011"
				};
		int m = input.length;
		int n = input[0].length();
		char[][] test = new char[m][n];
		for(int i = 0; i < m; i++){
			test[i] = input[i].toCharArray();
		}
		
		System.out.println(new NumberOfIslands().numIslands(test));
	}
	
	int count = 0;
	
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        	return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] == '1'){
        			bfs(grid,i,j);
        		}
        	}
        }
        return count;
    }
    
    private void bfs(char[][] grid, int i, int j){
    	Queue<Pair> queue = new LinkedList<Pair>();
    	queue.add(new Pair(i,j));
    	while(!queue.isEmpty()){
    		Pair p = queue.poll();
    		int row = p.row;
    		int col = p.col;
    		
    		if(grid[row][col] == '1'){
    			grid[row][col] = 'X';
    			
    			if(row - 1 >= 0){
    				if(grid[row-1][col] == '1')
    					queue.add(new Pair(row-1, col));
       		 	}
    			if(row + 1 < grid.length){
    				if(grid[row+1][col] == '1')
    					queue.add(new Pair(row+1, col));
    			}
    			if(col - 1 >= 0){
    				if(grid[row][col-1] == '1')
    					queue.add(new Pair(row, col-1));
    			}
    			if(col + 1 < grid[0].length){
    				if(grid[row][col+1] == '1')
    					queue.add(new Pair(row, col+1));
    			}
    		}
    	}
    	count++;
    }

    class Pair{
    	int row;
    	int col;
    	public Pair(int row, int col){
    		this.row = row;
    		this.col = col;
    	}
    }
}
