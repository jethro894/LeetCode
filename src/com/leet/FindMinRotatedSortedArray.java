package com.leet;

public class FindMinRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int findMin(int[] num) {
        if(num.length == 0)
        	return 0;
        
        int m = num[0];
        for(int i = 1; i < num.length; i++){
        	if(num[i] < m)
        		return num[i];
        	m = num[i];
        }
        return num[0];
    }

}
