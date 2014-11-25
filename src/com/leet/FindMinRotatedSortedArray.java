package com.leet;

public class FindMinRotatedSortedArray {	

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
