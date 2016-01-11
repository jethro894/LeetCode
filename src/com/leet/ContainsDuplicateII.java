package com.leet;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
        	return false;
        
        Map<Integer, Integer> lastApp = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
        	if(lastApp.containsKey(nums[i])){
        		if(i - lastApp.get(nums[i]) <= k){
        			return true;
        		}else{
        			lastApp.put(nums[i], i);
        		}
        	}else{
        		lastApp.put(nums[i], i);
        	}
        }
        return false;
    }
}
