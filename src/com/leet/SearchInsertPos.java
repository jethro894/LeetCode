package com.leet;

public class SearchInsertPos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,6};
		SearchInsertPos sip = new SearchInsertPos();
		System.out.println(sip.searchInsert(A, 2));
	}
	
	public int searchInsert(int[] A, int target) {
		if(A == null)
			return 0;
		
        int m = A.length;
        if(m == 0)
        	return 0;
        
        int i;
        for(i = 0; i < m; i++){
        	if(A[i] == target)
        		return i;
        	
        	else if(A[i] < target){
        		continue;
        	}else{
        		return i;
        	}
        }
        
        return i;
    }

}
