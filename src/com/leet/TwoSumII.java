package com.leet;

public class TwoSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2){
        	return null;
        }
        
        int start = 0;
        int end = numbers.length - 1;
        
        while(start < end){
        	int s = numbers[start];
        	int e = numbers[end];
        	
        	if(s + e == target){
        		return new int[] {start+1, end+1};
        	}else if(s + e > target){
        		end--;
        	}else{
        		start++;
        	}
        }
        
        return null;
    }
}
