package com.leet;

import java.util.Arrays;

public class ArrayPartitionI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0;
        for(int i =0; i < nums.length; i++){
        	if(i % 2 == 0){
        		sum += nums[i];
        	}
        }
        
        return sum;
    }
}
