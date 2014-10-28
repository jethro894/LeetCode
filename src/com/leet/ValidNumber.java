package com.leet;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isNumber(".2e81"));
	}

	public static boolean isNumber(String s) {
		try {
	        s = s.trim();
	        int n = s.length();
	        if ( n == 0 || (s.charAt(n-1) != '.' && (s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )) ) {
	            return false;
	        }
	        double i = Double.parseDouble(s);
	        return true;
	    }
	    catch (NumberFormatException e) {
	        return false;
	    }
    }
}
