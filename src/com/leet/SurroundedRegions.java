package com.leet;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public static void main(String[] args){
		String[] input = new String[]{
				"XOOOOOOOOOOOOOOOOOOO",
				"OXOOOOXOOOOOOOOOOOXX",
				"OOOOOOOOXOOOOOOOOOOX",
				"OOXOOOOOOOOOOOOOOOXO",
				"OOOOOXOOOOXOOOOOXOOX",
				"XOOOXOOOOOXOXOXOXOXO",
				"OOOOXOOXOOOOOXOOXOOO",
				"XOOOXXXOXOOOOXXOXOOO",
				"OOOOOXXXXOOOOXOOXOOO",
				"XOOOOXOOOOOOXXOOXOOX",
				"OOOOOOOOOOXOOXOOOXOX",
				"OOOOXOXOOXXOOOOOXOOO",
				"XXOOOOOXOOOOOOOOOOOO",
				"OXOXOOOXOXOOOXOXOXOO",
				"OOXOOOOOOOXOOOOOXOXO",
				"XXOOOOOOOOXOXXOOOXOO",
				"OOXOOOOOOOXOOXOXOXOO",
				"OOOXOOOOOXXXOOXOOOXO",
				"OOOOOOOOOOOOOOOOOOOO",
				"XOOOOXOOOXXOOXOXOXOO"
				};
		int m = input.length;
		int n = input[0].length();
		char[][] test = new char[m][n];
		for(int i = 0; i < m; i++){
			test[i] = input[i].toCharArray();
		}
		new SurroundedRegions().solve(test);
		for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		System.out.print(test[i][j] + " ");
        	}
        	System.out.println();
		}
		
		
	}
	
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
        	return;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
        	if(board[i][0] == 'O'){
        		bfs(board, i, 0);
        	}
        	if(board[i][n-1] == 'O'){
        		bfs(board, i, n-1);
        	}
        }
        
        for(int j = 0; j < n; j++){
        	if(board[0][j] == 'O'){
        		bfs(board, 0, j);
        	}
        	if(board[m-1][j] == 'O'){
        		bfs(board, m-1, j);
        	}
        }
        
        /*for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(board[i][j] == 'O')
        			board[i][j] = 'X';
        		else if(board[i][j] == 'Y')
        			board[i][j] = 'O';
        	}
        }*/
    }
    
    private void bfs(char[][] board, int m, int n){
    	 Queue<Pair> queue = new LinkedList<Pair>();
    	 queue.add(new Pair(m,n));
    	 while(!queue.isEmpty()){
    		 Pair p = queue.poll();
    		 int row = p.row;
    		 int col = p.col;
    		 
    		 if(board[row][col] == 'O'){
    			 board[row][col] = 'Y';
    			 
    			 if(row - 1 >= 0){
        			 if(board[row-1][col] == 'O')
        				 queue.add(new Pair(row-1, col));
        		 }
        		 if(row + 1 < board.length){
        			 if(board[row+1][col] == 'O')
        				 queue.add(new Pair(row+1, col));
        		 }
        		 if(col - 1 >= 0){
        			 if(board[row][col-1] == 'O')
        				 queue.add(new Pair(row, col-1));
        		 }
        		 if(col + 1 < board[0].length){
        			 if(board[row][col+1] == 'O'){
        				 queue.add(new Pair(row, col+1));
        			 }
        		 }
    		 }
    	 }
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
