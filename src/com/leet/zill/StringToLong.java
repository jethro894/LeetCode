package com.leet.zill;

public class StringToLong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringToLong().stringToLong("922337203685-477580"));
	}
	
	public long stringToLong(String s){
		if(s.length() == 0)
			return 0;
		
		int valid;
		boolean neg = false;
		if(s.charAt(0)=='-'){
			String min = ("" + Long.MIN_VALUE).substring(1);
			valid = -largerThanMax(s.substring(1), min);
			neg = true;
		}
		else{
			String max = ""+Long.MAX_VALUE;
			valid = -largerThanMax(s, max);
		}
		
		if(valid < 0)
			throw new NumberFormatException();
		else if(valid == 0){
			if(neg)
				return Long.MIN_VALUE;
			else
				return Long.MAX_VALUE;
		}else{
			int index = 0;
			if(neg)
				index = 1;
			
			long result = 0;
			while(index<s.length()){
				if(s.charAt(index)<'0' || s.charAt(index)>'9')
					throw new NumberFormatException();
				result = result*10+(s.charAt(index)-'0');
				index++;
			}
			
			if(neg)
				return -result;
			else
				return result;
		}
	}
	
	public int largerThanMax(String s, String max){
		if(s.length() == 0)
			return -1;
		if(s.charAt(0) != '-' && (s.charAt(0) < '0'||s.charAt(0) >'9'))
			return 1;
		
		if (s.length() < max.length())
			return -1;
		else if (s.length() > max.length())
			return 1;
		else{
			int index = 0;
			while(index < s.length()){
				if(s.charAt(index)<'0' || s.charAt(index)>'9')
					return 1;
				
				//System.out.print(s.charAt(index)+","+ max.charAt(index));
				if(s.charAt(index) < max.charAt(index))
					return -1;
				else if(s.charAt(index) > max.charAt(index))
					return 1;
				else
					index++;
			}
			return 0;
		}
	}
}
