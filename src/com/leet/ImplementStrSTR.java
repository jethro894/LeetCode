package com.leet;

import java.util.ArrayList;
import java.util.List;

public class ImplementStrSTR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(strStr("mississippi", "issip"));
	}

	public static String strStr(String haystack, String needle) {
		if(needle.length() > haystack.length())
			return (String)null;
		if(needle.length() == 0)
			return haystack;
		
        char[] mom = haystack.toCharArray();
        char[] son = needle.toCharArray();
        
        int i = 0;
        List<Integer> fs = new ArrayList<Integer>();
        int j = 0;
        while(i < mom.length && j < son.length){
        	if(mom[i] == son[0] && (i+son.length) < mom.length){
        		fs.add(i);
        	}
        	i++;
        }
        if(fs.size() == 0)
        	return (String)null;

        for(int k : fs){
        	j  = 0;
        	while(j < son.length &&  j+k < mom.length){
        		System.out.println(mom[j+k] + ":" + son[j] + ":" + (int)(j+k) + ":" + j);
        		if(mom[j+k] == son[j]){
        			if(j == son.length -1)
            			return haystack.substring(k);
        			j++;
        		}
        		else
        			break;
        	}
        }
        return (String)null;
        
        
    }
}
