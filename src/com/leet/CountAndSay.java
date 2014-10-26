package com.leet;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndSay(3);
	}
	
	public static void countAndSay(int n) {
        /*if(n < 1)
        	return "0";
        if(n == 1)
        	return "1";*/
        
        char[] preArray = "1".toCharArray();
        List<Character> charset;
        List<Integer> numbers;
        for(int i = 1; i <= n; i++){
        	charset = new ArrayList<Character>();
        	numbers = new ArrayList<Integer>();
        	
        	char lastChar = "~".toCharArray()[0];
        	int lastCharFirstAppearIndex = 0;
        	
        	for(int j = 0; j < preArray.length; j++){
        		if(preArray[j] != lastChar){
        			charset.add(preArray[j]);
        			numbers.add(j-lastCharFirstAppearIndex + 1);
        			lastChar = preArray[j];
        			lastCharFirstAppearIndex = j;
        		}
        		else{
        			String s = "";
        		}
        	}
        	
        	System.out.println("n = " + i);
        	for(char c : charset)
        		System.out.print(c + ",");
        	System.out.println();
        	for(int k : numbers)
        		System.out.print(k + ",");
        	System.out.println();
        }
    }
}
