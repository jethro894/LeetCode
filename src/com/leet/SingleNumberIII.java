package com.leet;

public class SingleNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,2,4,4,8,8,12,12,16,17,17,13,13,20};
		
		for(int i : new SingleNumberIII().singleNumber(A)){
			System.out.println(i);
		}
	}
	
	public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length < 4){
        	if(nums.length == 2 && nums[0] != nums[1]){
        		return nums;
        	}
        	return null;
        }
		
		int xor = 0;
        for(int i = 0; i < nums.length; i++){
        	xor ^= nums[i];
        }
        
        //by now xor is actually the two different numbers xor'ed together
        int b = 0;
        for(b = 0; b < 32; b++){
        	if(((xor >> b) & 1) == 1){
        		//find the first bit in xor that is 1. that means the two unique numbers have different bit value at this bit
        		break;
        	}
        }
        
        int xor1 = 0;
        for(int num : nums){
        	//select the numbers that have '1' at the bth bit. It will only contain one of the two unique numbers
        	if(((num >> b) & 1) == 1){
        		//xor and repeated numbers will cancel out themselves
        		xor1 ^= num;
        	}
        }
        
        //the other unique number is xor^xor1
        return new int[] {xor ^ xor1, xor1};
    }
}
