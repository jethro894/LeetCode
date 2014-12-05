package com.leet;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s.length() == 0)
        	return result;
        
        boolean[][] palin = new boolean[s.length()][s.length()];
        
        for(int i = s.length()-1; i >= 0; i--){
        	for(int j = i; j < s.length(); j++){
        		if(j == i)
        			palin[i][j] = true;
        		else{
        			if((palin[i+1][j-1] || j-i < 2) && s.charAt(i) == s.charAt(j))
        				palin[i][j] = true;
        		}
        	}
        }
        helper(s, 0, palin, new ArrayList<String>(), result);
        return result;
    }
	
	public void helper(String s, int remain_start, boolean[][] palin, List<String> sofar, List<List<String>> result){
		if(remain_start == s.length()){
			result.add(sofar);
			return;
		}
		
		for(int i = remain_start; i < s.length(); i++){
			if(palin[remain_start][i]){
				List<String> new_sofar = new ArrayList<String>(sofar);
				new_sofar.add(s.substring(remain_start, i+1));
				helper(s, i+1, palin, new_sofar, result);
			}
		}
	}
}
