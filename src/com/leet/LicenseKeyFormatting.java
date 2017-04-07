package com.leet;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("2-4A0r7-4k", 4));
	}
	
	public String licenseKeyFormatting(String S, int K) {
        String[] groups = S.split("-");
        int counter = K;
        StringBuilder sb = new StringBuilder();
        for(int i = groups.length-1; i >= 0; i--){
        	String group = groups[i];
        	for(int j = group.length()-1; j >= 0; j--){
        		char c = group.charAt(j);
        		sb.append(c);
        		counter--;
        		if(counter == 0){
        			sb.append('-');
        			counter = K;
        		}
        	}
        }
        sb.reverse();
        
        if(sb.length() > 0 && sb.charAt(0) == '-'){
        	sb.deleteCharAt(0);
        }
        
        return sb.toString().toUpperCase();
    }

}
