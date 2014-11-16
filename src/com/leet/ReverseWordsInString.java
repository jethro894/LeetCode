package com.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ReverseWordsInString {
	public String reverseWords(String s) {
		if(s.length() == 0 || s.trim().length() == 0)
			return "";
		
        StringTokenizer st = new StringTokenizer(s);
        List<String> tokens = new ArrayList<String>();
        while(st.hasMoreTokens()){
        	tokens.add(st.nextToken());
        }
        Collections.reverse(tokens);
        
        StringBuilder sb = new StringBuilder();
        for(String t : tokens){
        	sb.append(t + " ");
        }
        return sb.toString().trim();
    }
	
	public static void main(String[] args){
		System.out.println(new ReverseWordsInString().reverseWords("    a     b"));
	}
}
