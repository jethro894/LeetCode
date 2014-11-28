package com.leet;

public class Search2DMatrix {
	public static void main(String[] args){
		int[][] A = {{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50}};
		int target = 13;
		System.out.println(new Search2DMatrix().searchMatrix(A, target));
	}
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
        	return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[m-1][n-1])
        	return false;
        
        int[] row = findRow(matrix, target, 0, m-1);
        
        if(row == null)
        	return false;
        
        int start = 0; 
        int end = n-1;
        
        while(start < end){
        	int mid = start + (end-start)/2;
        	if(row[mid] == target)
        		return true;
        	if(row[mid] > target){
        		end = mid-1;
        	}
        	else{
        		start = mid+1;
        	}
        }
        
        if(start == end && row[start] == target)
        	return true;
        else
        	return false;
    }
	
	public int[] findRow(int[][] matrix, int target, int start, int end){
		if(start == end){
			if(matrix[start][0] <= target)
				return matrix[start];
			else
				 return null;
		}
		int mid_m = start + (end-start)/2;
		if(matrix[mid_m][0] <= target && matrix[mid_m + 1][0] > target)
			return matrix[mid_m];
		else if(matrix[mid_m][0] < target && matrix[mid_m + 1][0] <= target)
			return findRow(matrix, target, mid_m + 1, end);
		else
			return findRow(matrix, target, start, mid_m-1);
	}
	
}
