package com.leet;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {6,2,8,3,4,5,1};
		
		for(int num : new ProductOfArrayExceptSelf().productExceptSelf(nums)){
			System.out.print(num + ", ");
		}
	}
	
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
        	return null;
        }
        
        if(nums.length == 1){
        	return new int[] {0};
        }
        
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
        	if(i == 0){
        		res[i] = nums[i];
        	}else{
        		res[i] = nums[i]*res[i-1];
        	}
        }
        
        int temp = 0;
        for(int j = nums.length-1; j >=0; j--){
        	if(j == nums.length-1){
        		temp = nums[j];
        		res[j] = res[j-1];
        	}else if(j == 0){
        		res[j] = temp;
        	}else{
        		res[j] = res[j-1]*temp;
        		temp *= nums[j];
        	}
        }
        
        return res;
    }

}
