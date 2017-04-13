package com.leet;

public class MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {6,9,8};
		System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));
	}
	
	//Won't pass OJ. TLE for [1, Intger.MAX_VALUE]
	public int minMoves(int[] nums) {
        int count = 0;
        while(!allEqual(nums)){
        	move(nums);
        	count++;
        }
        return count;
    }
	
	public void move(int[] nums){
		int max = Integer.MIN_VALUE;
		int max_idx = -1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > max){
				max = nums[i];
				max_idx = i;
			}
		}
		
		for(int i = 0; i < nums.length; i++){
			if(i != max_idx){
				nums[i]++;
			}
		}
	}

	public boolean allEqual(int[] nums){
		int sample = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != sample){
				return false;
			}
		}
		return true;
	}
}
