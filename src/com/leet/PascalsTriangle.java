package com.leet;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> pascal = generate(10);
		for(List<Integer> list : pascal){
			for(int i : list){
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rows = new ArrayList<List<Integer>>();
		if(numRows <= 0)
			return rows;
	
		for(int i = 1; i <= numRows; i++){
			List<Integer> row_i = new ArrayList<Integer>();
			int[] thisRow = new int[i];
			thisRow[0] = 1;
			thisRow[i-1] = 1;
			for(int j = 1; j < i-1; j++){
				List<Integer> lastRow = rows.get(i-1-1);
				thisRow[j] = lastRow.get(j-1) + lastRow.get(j);
			}
			for(int k : thisRow) row_i.add(k);
			rows.add(row_i);
		}
		return rows;
    }

}
