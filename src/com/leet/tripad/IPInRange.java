package com.leet.tripad;

public class IPInRange {

	public static long ipToLong(String ip){
		String[] ips = ip.split(".");
		long result = 0;
		
		for(int i = 0; i < 4; i++){
			int power = 3-i;
			int part = Integer.parseInt(ips[i]);
			result += part*Math.pow(256, power);
		}
		return result;
	}
	
	public boolean inRange(long ip, long low, long high){
		if(ip <= high && ip >= low)
			return true;
		else
			return false;
	}
	
}
