package com.leet.tripad;

public class ConsecutiveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ConsecutiveZeroes().consecutiveZeroes(125000680));
	}

	public int consecutiveZeroes(int num){
		String test = num+"";
		String testreplace = test.replaceAll("00+","");
		return test.length() - testreplace.length();
	}
}
