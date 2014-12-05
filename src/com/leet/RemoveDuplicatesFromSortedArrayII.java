package com.leet;

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args){
		int[] A = {1,1,1,2,2,3};
		new RemoveDuplicatesFromSortedArrayII().removeDuplicates(A);
		for(int i : A)
			System.out.print(i+",");
	}
	public int removeDuplicates(int[] A) {
        if(A.length <= 2)
        	return A.length;
        
        int tail = 0; 
        int head = 0;
        int count = 0;
        
        while(head < A.length){
        	if(head+1 < A.length && A[head] == A[head+1]){
        		count++;
        		head++;
        		continue;
        	}
        	//System.out.println(A[head]+","+count);
        	count = count<2?count:1;
        	for(int i = count; i >= 0; i--){
    			A[tail] = A[head];
    			//System.out.println(A[tail]);
    			tail++;
    		}
        	head++;
    		count = 0;
        }
        //System.out.println(tail);
        return tail;
    }
}
