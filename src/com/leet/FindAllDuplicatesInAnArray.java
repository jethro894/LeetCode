package com.leet;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,1};
		System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(nums));
	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return res;
        }
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i] >= 0 ? nums[i] : -nums[i];
            if(num > 0 && nums[num-1] > 0){
                nums[num-1] = -nums[num-1];
            }else if(num > 0 && nums[num-1] < 0){
            	res.add(num);
            }
        }
        
        return res;
    }
}
