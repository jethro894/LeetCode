package com.leet;

public class ValidSudoku {
	public static void main(String[] args){
		char[][] sudoku = {{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'}};
		
		System.out.println(new ValidSudoku().isValidSudoku(sudoku));
		
	}
	public boolean isValidSudoku(char[][] board) {
        if(board == null)
        	return false;
        
        if(board.length != 9 || board[0].length != 9)
        	return false;
        
        boolean rows = checkRows(board);
        boolean columns = checkColumns(board);
        boolean boxes = checkBoxes(board);
        
        if(rows && columns && boxes)
        	return true;
        else
        	return false;
        
    }
	
	public boolean checkRows(char[][] board){
		int[] checker;
		for(int i = 0; i < 9; i++){
			checker = new int[9];
			for(int j = 0; j < 9; j++){
				if(board[i][j] != '.'){
					if(checker[board[i][j] - '1'] != 1)
						checker[board[i][j] - '1'] = 1;
					else
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkColumns(char[][] board){
		int[] checker;
		for(int j = 0; j < 9; j++){
			checker = new int[9];
			for(int i = 0; i < 9; i++){
				if(board[i][j] != '.'){
					if(checker[board[i][j] - '1'] != 1)
						checker[board[i][j] - '1'] = 1;
					else
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkBoxes(char[][] board){
		boolean all_set = true;
		int[] range = {0,3,6};
		for(int i : range){
			if(!all_set)
				break;
			for(int j : range){
				if(!checkBox(board, i, j)){
					all_set = false;
					break;
				}
			}
		}
		return all_set;
	}
	
	public boolean checkBox(char[][] board, int i_start, int j_start){
		int[] checker = new int[9];
		for(int i = i_start; i < 3 + i_start; i++){
			for(int j = j_start; j < 3 + j_start; j++){
				if(board[i][j] != '.'){
					if(checker[board[i][j] - '1'] != 1)
						checker[board[i][j] - '1'] = 1;
					else
						return false;
				}
			}
		}
		return true;
	}
}
