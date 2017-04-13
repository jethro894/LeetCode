package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
		System.out.println(new IncreasingSequences().findSubsequences(nums));
	}
	
	public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        if(nums == null || nums.length == 0){
        	return new ArrayList<List<Integer>>();
        }
        
        grow(res, nums, 0, new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(res);
    }
	
	public void grow(Set<List<Integer>> res, int[] nums, int i, List<Integer> cur){
		if(i == nums.length){
			if(cur.size() >= 2){
				res.add(cur);
			}
			return;
		}
		
		if(cur.size() == 0 || nums[i] >= cur.get(cur.size()-1)){
			//decide to add this digit
			List<Integer> include = new ArrayList<Integer>(cur);
			include.add(nums[i]);
			grow(res, nums, i+1, include);
			
			//decide not to add this digit
			List<Integer> exclude = new ArrayList<Integer>(cur);
			grow(res, nums, i+1, exclude);
		}else{
			grow(res, nums, i+1, cur);
		}
	}
}
