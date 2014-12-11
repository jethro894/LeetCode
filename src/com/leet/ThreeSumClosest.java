package com.leet;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        if(num.length < 2)
        	return 0;
        Arrays.sort(num);
        int min_diff = num[0] + num[1] + num[2] - target;
        for(int i = 0; i < num.length-2; i++){
        	int two = twoSumClosest(num, i+1, target-num[i]);
        	if(Math.abs(two)<Math.abs(min_diff))
        		min_diff = two;
        }
        return target + min_diff;
    }
	
	public int twoSumClosest(int[] num, int start, int target){
		int min_diff = num[start] + num[start+1] - target;
		if(start > num.length-2)
			return Integer.MIN_VALUE;
		int begin = start;
		int end = num.length-1;
		while(begin < end){
			int sum = num[begin] + num[end];
			int diff = sum-target;
			if(sum == target)
				return 0;
			if(Math.abs(diff) < Math.abs(min_diff))
				min_diff = diff;
			if(sum > target)
				end--;
			else
				begin++;
		}
		return min_diff;
	}
}
