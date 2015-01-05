package com.leet;

import java.util.HashMap;

public class MajorityElement {
	public int majorityElement(int[] num) {
        if(num.length == 0)
        	return -1;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : num){
        	if(!map.containsKey(i))
        		map.put(i, 1);
        	else
        		map.put(i, map.get(i)+1);
        }
        
        for(int i : map.keySet()){
        	if(map.get(i) > num.length/2)
        		return i;
        }
        
        return -1;
    }
}
