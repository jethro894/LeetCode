package com.leet;

public class PalindromePartitioningII {
	public int minCut(String s) {
       if(s.length() == 0 || s.length() == 1)
    	   return 0;
       
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
       
       int[] result = new int[s.length()+1];
       result[0] = 0;
       for(int i = 1; i <= s.length(); i++){
    	   result[i] = i-1;
    	   for(int j = 0; j < i; j++){
    		   if(palin[j][i]){
    			   result[i] = Math.min(result[i], result[j] + 1);
    		   }
    	   }
       }
       
       return result[s.length()];
    }
}
