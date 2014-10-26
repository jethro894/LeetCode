package com.leet;

public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPalindrome("\"Sue,\" Tom smiles, \"Selim smote us.\""));
	}

	public static boolean isPalindrome(String s) {
		if(s.length() == 0)
			return true;
		
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i < j){
        	while(i < chars.length && !(Character.isAlphabetic(chars[i]) || Character.isDigit(chars[i]))){
        		i++;
        	}
        	while(j >= 0 && !(Character.isAlphabetic(chars[j]) || Character.isDigit(chars[j]))){
        		j--;
        	}
        	System.out.println("i= " + i + ", j= " + j + ". char[i]= " + chars[i] + ", char[j]= " + chars[j]);
        	
        	if(i <= j){
        		if(chars[i] == chars[j]){
            		i++;
            		j--;
            	}else if(i == chars.length && j == -1){
            		break;
            	}else{
            		return false;
            	}
        	}
        	
        }
        return true;
    }
}
