package com.leet;

public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"asdsdfdfgdgh", "asdwertrtgh","asdsdf" , "asxcxcgdfh"};
		System.out.println(longestCommonPrefix(A));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
		
        StringBuilder sb = new StringBuilder();
        
        char[] buffer = new char[strs.length];
        int min_str_length = Integer.MAX_VALUE;
        int start = 0;
        
        for(int i = 0; i < strs.length; i++){
        	if(strs[i].length() > 0)
        		buffer[i] = strs[i].charAt(start);
        	if(strs[i].length() < min_str_length)
        		min_str_length = strs[i].length();
        }
        	
        if(!allTheSame(buffer) || min_str_length == 0)
        	return "";
        else{
        	sb.append(buffer[0]);
        	start++;
        }
        	
        while(start < min_str_length){
        	for(int i = 0; i < strs.length; i++)
            	buffer[i] = strs[i].charAt(start);
            if(allTheSame(buffer)){
            	sb.append(buffer[0]);
            	start++;
            }else
            	break;
        }
        
        return sb.toString();
    }
	
	public static boolean allTheSame(char[] certain_char){
		boolean result = true;
		char test = certain_char[0];
		for(char c : certain_char){
			if(c != test){
				result = false;
				break;
			}
		}
		return result;
	}

}
