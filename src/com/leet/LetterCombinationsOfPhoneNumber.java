package com.leet;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	public static void main(String[] args){
		for(String s : "iamastring".split("1*"))
			System.out.print(s + ",");
	}
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
        if(digits.length() == 0)
        	return list;
        
        list.add("");
        for(int i = 0; i < digits.length(); i++){
        	List<String> new_list = new ArrayList<String>();
        	String[] possible_new_chars = getLetters(digits.charAt(i));
        	for(String s : list){
        		for(String c : possible_new_chars){
        			if(c.length() > 0)
        			    new_list.add(s + c);
        		}
        	}
        	list = new_list;
        }
        return list;
    }
	
	public String[] getLetters(char digit){
		switch(digit)
		{
			case '2':
				return "abc".split("1*");
			case '3':
				return "def".split("1*");
			case '4':
				return "ghi".split("1*");
			case '5':
				return "jkl".split("1*");
			case '6':
				return "mno".split("1*");
			case '7':
				return "pqrs".split("1*");
			case '8':
				return "tuv".split("1*");
			case '9':
				return "wxyz".split("1*");
			default:
				return new String[0];
		}
	}
}
