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

	public int findMinLogN(int[] num){
		if(num.length == 0)
        	return 0;
		
		if(num[0] <= num[num.length-1])
			return num[0];
		
		return helper(num, 0, num.length -1);
	}
	
	public int helper(int[] num, int start, int end){
		if(start == end)
			return num[start];
		
		if(end - start == 1)
			return Math.min(num[start], num[end]);
		
		if(num[start] <= num[end])
			return num[start];
		
		int median = start + (end - start)/2;
		
		if(num[median] < num[median-1] && num[median] < num[median+1])
			return num[median];
		
		if(num[start] <= num[median] && num[median] >= num[end])
			return helper(num, median+1, end);
		else
			return helper(num, start, median-1);
	}
}
