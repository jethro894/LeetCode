package com.leet;

public class SearchRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
        if(A.length == 0)
        	return false;
        	
        if(helper(A, 0, A.length -1, target) >= 0)
            return true;
        else
            return false;
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
		}
		if(num[median] > num[end]){
			if(num[start] < target && target < num[median])
				return helper(num, start, median-1, target);
			else
				return helper(num, median+1, end, target);
		}
		int find1 = -1;
		int find2 = -1;
		if(num[median] == num[start]){
			find1 = helper(num, start, median-1, target);
			find2 = helper(num, median, end, target);
		}
		
		if(find1 == -1 && find2 == -1){
			if(num[median] == num[end]){
				find1 = helper(num, start, median, target);
				find2 = helper(num, median, end, target);
			}
		}

		if(find1 == -1 && find2 == -1)
			return -1;
		else
			return Math.max(find1, find2);
	}
}
