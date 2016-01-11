package com.leet;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean containsDuplicate(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return false;
        Set map = new HashSet<Integer>();
        for(int i : nums){
        	if(map.contains(i))
        		return true;
        	else
        		map.add(i);
        }
        return false;
    }
}
