package com.leet;

public class SquareRootX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SquareRootX().sqrt(2147483647));
	}
	
	public int sqrt(int x) {
        if(x < 0)
        	return -1;
        
        if(x == 0)
        	return 0;
        
        int start = 1;
        int end = x/2+1;
        
        while(start <= end){
        	System.out.println("start: " + start + ", end: " + end);
        	int mid = (start + end)/2;
        	System.out.println("mid:" + mid);
        	if(mid <= x/mid && mid+1 > x/(mid+1)){
        		return mid;
        	}
        	if(mid < x/mid){
        		start = mid+1;
        		continue;
        	}
        	if(mid > x/mid){
        		end = mid;
        		continue;
        	}
        }
        return 0;
    }
	
}
