package com.leet;

public class ImplementStrSTR {

	public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() != 0)
        	return -1;
        else if(haystack.length() == 0 || needle.length() == 0)
        	return 0;
        
        int n = haystack.length();
        int m = needle.length();
        
        if(n < m)
        	return -1;
        
        char[] need = needle.toCharArray();
        for(int i = 0; i <= n-m; i++){
        	String candidate = haystack.substring(i, i+m);
        	System.out.println(candidate);
        	boolean found = true;
        	for(int j = 0; j < m; j++){
        		if(need[j] != candidate.charAt(j)){
        			found = false;
        			break;
        		}
        	}
        	if(found){
        		return i;
        	}
        }
        return -1;
    }
}
