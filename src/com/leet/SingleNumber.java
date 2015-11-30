package com.leet;

import java.util.HashMap;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,2,2,4,4,4,8,8,8,12,12,12,16,17,17,17,13,13,13};
		System.out.print(singleNumber(A));
	}
	
	public static int singleNumber(int[] A) {
		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		for(Integer i : A){
			int number_of_apparence= record.get(i) == null ? 0 : record.get(i);
			if(number_of_apparence<2)
				record.put(i, number_of_apparence+1);	
			else
				record.remove(i);
		}
		return (Integer) record.keySet().toArray()[0];
    }
}
