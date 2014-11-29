package com.leet;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        helper(n, 0, new int[n], result);
        return result;
    }
	
	public void helper(int n, int row, int[] queen_location, List<String[]> result){
		if(row == n){
			String[] solution = new String[n];
			for(int i = 0; i < n; i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < n; j++){
					if(queen_location[i] == j)
						sb.append("Q");
					else
						sb.append(".");
				}
				solution[i] = sb.toString();
			}
			result.add(solution);
			return;
		}
		else{
			for(int i = 0; i < n; i++){
				queen_location[row] = i;
				if(valid(row, queen_location)){
					helper(n, row+1, queen_location, result);
				}
			}
		}
	}
	
	public boolean valid(int row, int[] queen_location){
		for(int i = 0; i < row; i++){
			if(queen_location[i] == queen_location[row] || Math.abs(queen_location[row] - queen_location[i]) == row-i)
				return false;
		}
		return true;
	}
}
