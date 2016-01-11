package com.leet;

import java.util.TreeSet;

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(nums == null || nums.length == 0 || k <= 0 || t < 0)
        	return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	int n = nums[i];
        	if(set.floor(n) != null && set.floor(n) + t >= n)
        		return true;
        	if(set.ceiling(n) != null && n + t >= set.ceiling(n))
        		return true;
        	set.add(n);
        	if(i >= k)
        		set.remove(nums[i-k]);
        }
        return false;
    }

}
