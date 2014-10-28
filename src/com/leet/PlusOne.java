package com.leet;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0};
		for(int i : plusOne(A)){
			System.out.print(i + ",");
		}
		
	}

	public static int[] plusOne(int[] digits) {
		if( digits.length == 0)
			return null;
        int carry = 1;
        int sum;
        for (int i = digits.length-1; i>= 0; i--){
        	sum = digits[i] + carry;
        	digits[i] = sum%10;
        	carry = sum/10;
        }
        if(carry > 0){
        	int[] newDigits = new int[digits.length + 1];
        	newDigits[0] = carry;
        	for(int i = 1; i < newDigits.length; i++){
        		newDigits[i] = digits[i-1];
        	}
        	return newDigits;
        }else
        	return digits;
    }
}
