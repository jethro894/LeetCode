package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        
        if(strs.length == 0)
        	return result;
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strs){
        	char[] strc = str.toCharArray();
        	Arrays.sort(strc);
        	String strcs = strc.toString();
        	if(map.containsKey(strcs)){
        		List<String> list = map.get(strcs);
        		list.add(str);
        		map.put(strcs, list);
        	}else{
        		List<String> list = new ArrayList<String>();
        		list.add(str);
        		map.put(strcs, list);
        	}
        }
        
        for(List<String> list : map.values()){
        	if(list.size() > 1){
        		for(String str : list)
        			result.add(str);
        	}
        }
        
        return result;
    }
}
