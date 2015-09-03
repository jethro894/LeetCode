package com.leet;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rob(int[] nums) {
        if(nums.length == 0)
        	return 0;
        
        int[] max = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
        	if(i >= 2){
        		max[i] = Math.max(max[i-2] + nums[i], max[i-1]);
        	}
        	else if(i == 1)
        		max[i] = Math.max(nums[i], nums[i-1]);
        	else
        		max[i] = nums[i];
        }
        
        return max[nums.length-1];
    }

}
