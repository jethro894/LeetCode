package com.leet;

public class RangeSumQueryImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
		NumArrayImmutable numArray = new NumArrayImmutable(nums);
		
		System.out.println(numArray.sumRange(1,1));
	}

	static class NumArrayImmutable {

	    int[] sumSoFar;
	    public NumArrayImmutable(int[] nums) {
	        if(nums == null || nums.length == 0){
	            return;
	        }
	        sumSoFar = new int[nums.length];
	        for(int i = 0; i < nums.length; i++){
	            int pre = 0;
	            if(i > 0){pre = sumSoFar[i-1];}
	            sumSoFar[i] = pre + nums[i];
	        }
	    }

	    public int sumRange(int i, int j) {
	        if(i < 0 || j >= sumSoFar.length || i > j){
	            return -1;
	        }
	        
	        if(j < 0){
	        	return 0;
	        }
	        
	        if(i == 0){
	            return sumSoFar[j];
	        }
	        
	        return sumRange(0, j) - sumRange(0, i-1);
	    }
	}
}
