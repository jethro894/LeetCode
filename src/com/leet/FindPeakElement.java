package com.leet;

public class FindPeakElement {
	public static void main(String[] args){
		int[] A = {2,1};
		new FindPeakElement().findPeakElement(A);
	}
	public int findPeakElement(int[] num) {
        if(num.length == 0 || num.length == 1)
        	return 0;
        
        return find(num, 0, num.length-1);
    }
	
	public int find(int[] num, int start, int end){
		if(start == end)
			return start;
		
		int mid = start + (end-start)/2;
		System.out.println(start + "," + end+","+mid);
		if(num[mid] < num[mid+1])
			return find(num, mid+1, end);
		else
			return find(num, start, mid);
		
	}
}
