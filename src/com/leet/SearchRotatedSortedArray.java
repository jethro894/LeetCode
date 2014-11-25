package com.leet;

public class SearchRotatedSortedArray {
	public int search(int[] num, int target){
		if(num.length == 0)
        	return -1;

		return helper(num, 0, num.length -1, target);
	}
	 
	public int helper(int[] num, int start, int end, int target){
		System.out.println("start: "+start+", end:" + end);
		if(start == end){
			if(num[start] == target)
				return start;
			else
				return -1;
		}
		if(start + 1 == end){
			if(num[start] != target && num[end] != target)
				return -1;
		}
		
		if(num[start] == target)
			return start;
		if(num[end] == target)
			return end;
		
		int median = start + (end - start)/2;
		System.out.println("median: "+median);
		
		if(num[median] == target)
			return median;
		
		if(num[median] < num[end]){
			if(num[median] < target && target < num[end])
				return helper(num, median+1, end, target);
			else
				return helper(num, start, median-1, target);
		}else{
			if(num[start] < target && target < num[median])
				return helper(num, start, median-1, target);
			else
				return helper(num, median+1, end, target);
		}
	}
}
