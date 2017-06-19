package com.leet;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {8,9,9,9,9,9};
		int target = 9;
		
		for(int i : new SearchRange().searchRange(nums, target)){
			System.out.print(i + ", ");
		}
	}
	
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        
        start = helper(nums, target, 0, nums.length-1, true);
        end = helper(nums, target, 0, nums.length-1, false);
        
        return new int[] {start, end};
    }
    
    public int helper(int[] nums, int target, int f, int l, boolean searchStart){
    	if(f > l || f < 0 || l >= nums.length){
    		return -1;
    	}
    	
    	if(f == l){
    		if(nums[f] == target){
    			return f;
    		}else{
    			return -1;
    		}
    	}
    	
    	int mid = (f + l) / 2;
    	if(nums[mid] < target){
    		return helper(nums, target, mid+1, l, searchStart);
    	}else if (nums[mid] > target){
    		return helper(nums, target, f, mid-1, searchStart);
    	}else{
    		if(searchStart){
    			if(mid-1 < 0 || nums[mid-1] < target){
    				return mid;
    			}else{
    				return helper(nums, target, f, mid-1, searchStart);
    			}
    		}else{
    			if(mid+1 >= nums.length || nums[mid+1] > target){
    				return mid;
    			}else{
    				return helper(nums, target, mid+1, l, searchStart); 
    			}
    		}
    	}
    }
}
