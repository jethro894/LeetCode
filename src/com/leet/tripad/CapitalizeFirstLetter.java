package com.leet.tripad;

public class CapitalizeFirstLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CapitalizeFirstLetter().capitalize("this    si   sdf   st . we "));
	}
	
	public String capitalize(String sentence){
		if(sentence.length() == 0)
			return null;
		
		char[] c = sentence.toCharArray();
		for(int i = 0; i < c.length - 1; i++){
			if(c[i] == ' '){
				if(c[i+1] != ' '){
					c[i+1] = capChar(c[i+1]);
				}
			}
		}
		
		return new String(c);
	}
	
	public char capChar(char c){
		int diff = c-'a';
		if( diff >= 0 && diff <= 25)
			return (char)(diff + 'A');
		else
			return c;
	}
}
