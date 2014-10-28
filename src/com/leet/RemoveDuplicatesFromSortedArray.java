package com.leet;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] A) {
		if(A == null ||A.length == 0)
			return  0;
		
        int head = 1;
        int tail = 0;
        
        while(head < A.length){
        	if(A[tail] == A[head]){
        		head++;
        	}else{
        		tail++;
        		A[tail] = A[head];
        		head++;
        	}
        }

		return tail+1;
    }

}
