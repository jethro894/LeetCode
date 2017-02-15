package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class SubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {1,2,2};
		for(List<Integer> list : new SubsetII().subsetsWithDupRecursive(s))
			System.out.println(list);
	}
	Set<List<Integer>> result;
	
	public List<List<Integer>> subsetsWithDupRecursive(int[] nums) {
        result = new HashSet<List<Integer>>();
		if(nums.length == 0){
			return new ArrayList<List<Integer>>(result);
		}
		
		Arrays.sort(nums);
		List<Integer> seed = new ArrayList<Integer>();
		grow(nums, 0, seed);
		
		return new ArrayList<List<Integer>>(result);
    }
	
	public void grow(int[] nums, int i, List<Integer> pre){
		if(i >= nums.length){
			result.add(pre);
			return;
		}
		
		int count = 1;
		for(int j = i+1; j < nums.length; j++){
			if(nums[j] != nums[i]){
				break;
			}else{
				count++;
			}
		}
		
		List<Integer> withoutThisDigit = new ArrayList<Integer>(pre);
		grow(nums, i + 1, withoutThisDigit);
		
		for(int l = 0; l < count; l++){
			List<Integer> withThisDigit = new ArrayList<Integer>(pre);
			for(int k = 0; k < count; k++){
				withThisDigit.add(nums[i]);
			}
			grow(nums, i + count, withThisDigit);
		}
	}
	
	/*public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<List<Integer>>();
		if(nums.length == 0){
			return result;
		}
		
		Arrays.sort(nums);
		List<Integer> seed = new ArrayList<Integer>();
		Stack<Parameter> stack = new Stack<Parameter>();
		
		Parameter init = new Parameter(0, seed);
		stack.push(init);
		while(!stack.empty()){
			Parameter cur = stack.pop();
			int i = cur.i;
			List<Integer> pre = cur.pre;
			
			if(i >= nums.length){
				result.add(pre);
			}
			
			int count = 1;
			for(int j = i+1; j < nums.length; j++){
				if(nums[j] != nums[i]){
					break;
				}else{
					count++;
				}
			}
			
			List<Integer> withoutThisDigit = new ArrayList<Integer>(pre);
			Parameter without = new Parameter(i+1, withoutThisDigit);
			stack.push(without);
			
			for(int l = i; l - i < count; l++){
				List<Integer> withThisDigit = new ArrayList<Integer>(pre);
				for(int k = 0; k < l-i+1; k++){
					withThisDigit.add(nums[i]);
				}
				grow(nums, l-i+1, withThisDigit);
			}
		}
		
		return result;
    }
	
	class Parameter{
		int i;
		List<Integer> pre;
		
		Parameter(int i, List<Integer> pre){
			this.i = i;
			this.pre = pre;
		}
	}*/
}
