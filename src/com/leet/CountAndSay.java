package com.leet;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndSay(5);
	}
	
	public static String countAndSay(int n) {
        if(n <= 0)
        	return (String) null;
        
        	
        String current = "1";
        
        if(n == 1)
        	return current;
        
        List<Pair> list;
        for(int i = 2; i <= n; i++){
        	list = strToCount(current);
        	current = countToStr(list);
        	//System.out.print(current + ", ");
        }
        
        return current;
    }
	
	public static List<Pair> strToCount(String str){
		char[] array = str.toCharArray();
		List<Pair> list = new ArrayList<Pair>();
		
		if(str.length() == 0)
			return list;
		
		char pre = array[0];
		int count = 0;
		for(char c : array){
			if (c != pre){
				list.add(new Pair(pre,count));
				pre = c;
				count = 1;
			}
			else{
				count++;
			}
		}
		list.add(new Pair(array[array.length-1], count));
		return list;
	}
	
	public static String countToStr(List<Pair> list){
		if(list.size() == 0)
			return (String)null;
		
		StringBuilder sb = new StringBuilder();
		for(Pair p : list){
			sb.append(p.value);
			sb.append(p.key);
		}
		
		return sb.toString();
	}
}

class Pair{
	char key;
	int value;
	public Pair(char c, int i){
		this.key = c;
		this.value = i;
	}
}
