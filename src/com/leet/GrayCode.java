package com.leet;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
        if(n < 0)
        	return null;
        List<Integer> list = new ArrayList<Integer>();
        
        if(n == 0){
        	list.add(0);
        	return list;
        }
        
        list.add(0);
        list.add(1);
        
        for(int i = 2; i <= n; i++){
        	raiseByOne(list, i-1);
        }
        
        return list;
    }
	
	public void raiseByOne(List<Integer> gray, int bits_to_shift){
		for(int i = gray.size() - 1; i >= 0; i--){
			gray.add(gray.get(i) + (1<<bits_to_shift));
		}
	}
}
