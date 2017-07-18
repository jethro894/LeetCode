package com.leet;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        if(s.length() == 0)
        	return false;
        
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        
        for(int i = 0; i < s.length(); i++){
        	for(int j = 0; j <= i; j++){
        		if(result[j] && dict.contains(s.substring(j, i+1))){
        			result[i+1] = true;
        			break;
        		}
        	}
        }
        
        return result[s.length()];
    }
	
	public int wordBreakNum(String s, Set<String> dict){
		if(s.length() == 0){
        	return 0;
		}
		
		int[] result = new int[s.length() + 1];
		result[0] = 1;
		
		for(int i = 0; i < s.length(); i++){
        	for(int j = 0; j <= i; j++){
        		if(result[j] > 0 && dict.contains(s.substring(j, i+1))){
        			result[i+1]++;
        		}
        	}
        }
        
        return result[s.length()];
	}
}
