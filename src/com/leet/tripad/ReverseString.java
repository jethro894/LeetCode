package com.leet.tripad;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseString().reverse("aaa   sd reverseMe     "));
	}
	
	public String reverse(String str){
		if(str.length() == 0)
			return str;
		char[] chars = str.toCharArray();
		int i = 0;
		int j = chars.length-1;
		char temp;
		while(i <= j){
			temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			
			i++;
			j--;
		}
		
		return new String(chars);
	}

}
