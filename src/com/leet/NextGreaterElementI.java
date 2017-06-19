package com.leet;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums == null || nums == null){
        	return null;
        }
        if(findNums.length == 0 || nums.length == 0){
        	return new int[0];
        }
        
        Map<Integer, Integer> numIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
        	numIndex.put(nums[i], i);
        }
        
        int[] res = new int[findNums.length];
        for(int j = 0; j < findNums.length; j++){
        	int num = findNums[j];
        	
        	int nextGreater = -1;
        	if(numIndex.containsKey(num)){
        		int index = numIndex.get(num);
        		
        		findNextGreater:
        		for(int k = index+1; k < nums.length; k++){
        			if(nums[k] > num){
        				nextGreater = nums[k];
        				break findNextGreater;
        			}
        		}
        	}
        	
        	res[j] = nextGreater;
        }
        
        return res;
    }
}
