package com.leet;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0)
        	return combinations;
        helper(n,k,1,new ArrayList<Integer>(), combinations);
        return combinations;
    }
	
	public void helper(int n, int k, int seed, List<Integer> com_sofar, List<List<Integer>> res){
		if(com_sofar.size() == k){
			res.add(com_sofar);
			return;
		}
		for(int i = seed; i <= n; i++){
			List<Integer> new_list = new ArrayList<Integer>(com_sofar);
			new_list.add(i);
			helper(n, k, i+1, new_list, res);
		}
	}
}
