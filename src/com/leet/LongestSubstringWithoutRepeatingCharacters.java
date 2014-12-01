package com.leet;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
        	return 0;
        if(s.length() == 1)
        	return 1;
        
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int right = 1;
        int max = 1;
        
        set.add(s.charAt(left));
        
        while(right < s.length()){
        	if(!set.contains(s.charAt(right))){
        		set.add(s.charAt(right));
        	}else{
        	    if(right - left > max)
    			    max = right - left;
        		while(set.contains(s.charAt(right))){
        			set.remove(s.charAt(left));
        			left++;
        		}
        		set.add(s.charAt(right));
        	}
        	right++;
        }

        return Math.max(max, right-left);
    }
}
