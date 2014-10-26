package com.leet;

public class Atoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(atoi("  -0012a42"));
	}
	
	public static int atoi(String str) {
        long result  = 0;
        
        if(str.length() == 0)
        	return 0;
        String s = str.trim();
        char[] strChars = s.toCharArray();
        if(!isDigit(strChars[0]) && strChars[0] != "-".charAt(0) && strChars[0] != "+".charAt(0)){
        	return 0;
        }
        for(int i = 1; i < s.length(); i++){
        	if(!isDigit(strChars[i])){
        		s = s.substring(0, i);
        	}
        }
        
        int number_of_digits;
        for(int j = s.length() - 1; j >= 0; j--){
        	number_of_digits = s.length() - 1 - j;
        	if(strChars[j] == "-".charAt(0)){
        		result = -result;
        		
        	}else if(strChars[j] != "+".charAt(0)){
        		result = result + ((int)strChars[j] - (int)"0".charAt(0)) * (int)Math.pow(10, number_of_digits);
        	}
        	
        }
        if(result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE)
        	return (int)result;
        else if(result > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else
        	return Integer.MIN_VALUE;
    }
	
	public static boolean isDigit(char c){
		char zero = "0".charAt(0);
		if(c-zero < 0 || c- zero > 9)
			return false;
		return true;
	}

}
