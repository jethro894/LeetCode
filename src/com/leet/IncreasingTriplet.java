package com.leet;

public class IncreasingTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{5,1,5,5,2,5,4}));
	}
	public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;
        
        int big = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;
        
        for(int i : nums){
        	if(i < small){
        		small = i;
        	}
        	else if(i < big){
        		big = i;
        	}else{
        		return true;
        	}
        }
        return false;
    }
}
