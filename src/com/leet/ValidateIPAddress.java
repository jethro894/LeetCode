package com.leet;

public class ValidateIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidateIPAddress().validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
	}
	
	public String validIPAddress(String IP) {
		String neither = "Neither";
		String ipv4 = "IPv4";
		String ipv6 = "IPv6";
		
        if(IP == null || IP.length() == 0){
        	return neither;
        }
        
        
        String[] ipv4Groups = IP.split("\\.");
        if(ipv4Groups != null && ipv4Groups.length == 4){
        	//Possible ipv4
        	for(String token : ipv4Groups){
        		if(token.length() > 3){
        			return neither;
        		}
        		try{
        			int num = Integer.parseInt(token);
        			if(num < 0 || num > 255){
        				return neither;
        			}else if(num != 0 && token.startsWith("0")){
        				return neither;
    				}else if(num == 0 && token.length() > 1){
        				return neither;
    				}
        		}catch(Exception e){
        			return neither;
        		}
        	}
        	if(IP.startsWith(".") || IP.endsWith(".")){
        		return neither;
        	}
        	return ipv4;
        }else{
        	String[] ipv6Groups = IP.split("\\:");
        	if(ipv6Groups != null && ipv6Groups.length == 8){
        		//Possible ipv6
        		for(String token : ipv6Groups){
        			if(token.length() > 4){
            			return neither;
            		}
        			try{
            			int hex = Integer.parseInt(token, 16);
            			if(hex < 0 || hex > 65535){
            				return neither;
            			}else if(hex == 0 && !token.startsWith("0")){
            				return neither;
        				}
            		}catch(Exception e){
            			return neither;
            		}
        		}
        		if(IP.startsWith(":") || IP.endsWith(":")){
            		return neither;
            	}
        		return ipv6;
        	}else{
        		return neither;
        	}
        }
    }

}
