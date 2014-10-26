package com.leet;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> pascalRow = getRow(0);
			for(int i : pascalRow){
				System.out.print(i + ",");
			}
			
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> this_Row = new ArrayList<Integer>();
		rowIndex++;
		if(rowIndex <= 0)
			return this_Row;
		
		List<Integer> lastRow = new ArrayList<Integer>();
		this_Row.add(1);
		for(int i = 2; i <= rowIndex; i++){
			lastRow = new ArrayList<Integer>(this_Row);
			this_Row = new ArrayList<Integer>();
			int[] thisRow = new int[i];
			thisRow[0] = 1;
			thisRow[i-1] = 1;
			for(int j = 1; j < i-1; j++){
				thisRow[j] = lastRow.get(j-1) + lastRow.get(j);
			}
			for(int k : thisRow) this_Row.add(k);
		}
		return this_Row;
    }
}
