package com.leet;

public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPalindrome(11));
	}

	public static boolean isPalindrome(int x) {
		int x_copy = x;
		if(x < 0)
			return false;
        
		if(x < 10){
			return true;
		}
		
        int reverse = 0;
        while(x > 0){
        	reverse = reverse * 10 + x % 10;
        	x /= 10;
        }
        System.out.println(reverse);
        System.out.println(x);
        return reverse == x_copy? true: false;
    }
}
