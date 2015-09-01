package com.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LargestNumber().largestNumber(new int[] {3,30,34,5,9}));
	}
	
	public String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0)
			return "";
		if(nums.length == 1)
			return Integer.toString(nums[0]);
		
		List<String> numList = new ArrayList<String>();
		for(int i : nums)
			numList.add(Integer.toString(i));
		
		Collections.sort(numList, new NumStringComparator());
		
		StringBuilder sb = new StringBuilder();
		for(String numStr : numList){
			System.out.println(numStr);
			sb.append(numStr);
		}
		
		for(int i = 0; i < sb.length(); i++)
			if(sb.charAt(i) == '0')
				sb.setCharAt(i, 'x');
			else
				break;
		
		String result = sb.toString().replace("x", "");
		return result.length() == 0 ? "0":result;
    }
	
	class NumStringComparator implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			String s1 = arg0 + arg1;
			String s2 = arg1 + arg0;
			return (int)-(Long.parseLong(s1) - Long.parseLong(s2));
		}
		
	}
}
