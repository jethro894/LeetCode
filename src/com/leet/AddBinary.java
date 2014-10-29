package com.leet;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(addBinary("111111", "111111"));
	}
	
	public static String addBinary(String a, String b) {
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        
        int i = ac.length-1;
        int j = bc.length-1;
        
        while(i >= 0 || j >= 0){
        	if(i < 0){
        		sum = charToDigit(bc[j]) + carry;
        		sb.append(sum%2);
        		carry = sum/2;
        		j--;
        		continue;
        	}
        	
        	if(j < 0){
        		sum = charToDigit(ac[i]) + carry;
        		sb.append(sum%2);
        		carry = sum/2;
        		i--;
        		continue;
        	}
        	
        	sum = charToDigit(ac[i]) + charToDigit(bc[j]) + carry;
    		sb.append(sum%2);
    		carry = sum/2;
    		i--;
    		j--;
        	
        }
        
        if(carry > 0)
        	sb.append(1);
        
        System.out.println("carry = " + carry);
        return sb.reverse().toString();
    }
	
	public static int charToDigit(char c){
		return (int)(c-(char)'0');
	}
	

}
