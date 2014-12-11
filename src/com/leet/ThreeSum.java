package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public static void main(String[] args){
		int[] A = {0,0,0};
		for(List<Integer> list : new ThreeSum().threeSum(A)){
			System.out.println(list);
		}
	}
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length == 0)
        	return result;
        
        Arrays.sort(num);
        
        for(int i = 0; i < num.length-2; i++){
        	List<List<Integer>> two = twoSum(num, i+1, -num[i]);
        	if(two.size() > 0){
        		for (List<Integer> t : two){
        			t.add(0, num[i]);
        			result.add(t);
        		}
        	}
        }
        Set<List<Integer>> result_set = new HashSet<List<Integer>>(result);
        result = new ArrayList<List<Integer>>();
        result.addAll(result_set);
        return result;
    }
	
	public List<List<Integer>> twoSum(int[] num, int start, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(start > num.length-2)
			return result;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = start; i < num.length; i++){
			if(map.containsKey(target-num[i])){
				List<Integer> two = new ArrayList<Integer>();
				two.add(target-num[i]);
				two.add(num[i]);
				result.add(two);
			}
			map.put(num[i], 1);
			
		}
		return result;
	}
}
