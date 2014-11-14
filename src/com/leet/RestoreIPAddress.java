package com.leet;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new RestoreIPAddress().restoreIpAddresses("25525511135"));
	}
	List<String> results;
	public List<String> restoreIpAddresses(String s) {
		results = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12)
        	return results;
        List<Integer> previous = new ArrayList<Integer>();
        parse(s, previous);
        return results;
    }
	
	public void parse(String s, List<Integer> pre){
		//System.out.println("parsing: " + s + " with pre size: " + pre.size());
		//System.out.println(pre);
		if(s.length() == 0 && pre.size() == 4){
			String ip1 = pre.get(0).toString();
			String ip2 = pre.get(1).toString();
			String ip3 = pre.get(2).toString();
			String ip4 = pre.get(3).toString();
			results.add(ip1+"."+ip2+"."+ip3+"."+ip4);
			return;
		}
		
		if(s.length() == 0)
			return;
		if(pre.size() >= 4)
			return;
		
		int one_digit = valid(s.substring(0, 1));
		if(one_digit != -1){
			List<Integer> prepre = new ArrayList<Integer>(pre);
			prepre.add(one_digit);
			parse(sub(s,1), prepre);
		}
		
		if(s.length() > 1){
			int two_digit = valid(s.substring(0, 2));
			if(two_digit != -1){
				List<Integer> prepre = new ArrayList<Integer>(pre);
				prepre.add(two_digit);
				parse(sub(s,2), prepre);
			}
		}
		
		if(s.length() > 2){
			int three_digit = valid(s.substring(0, 3));
			if(three_digit != -1){
				List<Integer> prepre = new ArrayList<Integer>(pre);
				prepre.add(three_digit);
				parse(sub(s,3), prepre);
			}
		}
	}
	
	public int valid(String s){
		try{
			if(s.charAt(0)=='0' && s.length()>1)  
		        return -1; 
			
			int i = Integer.parseInt(s);
			if(i >= 0 && i <= 255)
				return i;
			return -1;
		}catch(Exception e){
			return -1;
		}
	}
	
	public String sub(String s, int beginIndex){
		try{
			return s.substring(beginIndex);
		}catch(Exception e){
			String nullstring = null;
			return nullstring;
		}
	}
	
}
