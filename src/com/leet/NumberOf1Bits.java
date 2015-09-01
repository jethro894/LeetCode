package com.leet;

public class NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumberOf1Bits().hammingWeight(11));
	}
	
	public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
        	if((n&1) == 1)
        		count++;
        	n = n >> 1;
        }
        return count;
    }

}
