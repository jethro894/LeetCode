package com.leet.briEd;

public class PartitionArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sample = {1,2,3,6,0,0,3,1,9,0};
		new PartitionArray().partition(sample);
		for(int i : sample){
			System.out.print(i + ",");
		}
	}
	
	public void partition(int[] A){
		if(A.length == 0 || A.length == 1)
			return;
		
		int i = 0;
		boolean first_search = true;
		int j = 0;
		int temp;
		while(i < A.length - 1){
			if(A[i] != 0){
				i++;
				continue;
			}
			
			if(first_search){
				j = i+1;
				first_search = false;
			}
				
			while(j < A.length){
				if(A[j] == 0)
					j++;
				else
					break;
			}
			
			if(j < A.length){
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				
				i++;
				j++;
			}
			else
				break;
		}
	}
}
