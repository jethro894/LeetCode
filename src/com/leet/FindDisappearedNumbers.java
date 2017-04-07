package com.leet;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {4,3,2,7,8,2,3,1};
		System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(nums));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return res;
        }
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            if(num > 0 && nums[num-1] > 0){
                nums[num-1] = -nums[num-1];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}
